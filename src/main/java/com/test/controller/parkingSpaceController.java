package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.model.ParkingSpace;
import com.test.service.ParkingSpaceService;
import com.test.vo.SelectValue;
import com.test.vo.searcher.ParkingSpaceManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XinLian on 2016/3/13.
 */
@Controller("parkingSpaceManageController")
public class parkingSpaceController extends BaseController{

    @Autowired
    ParkingSpaceService parkingSpaceService;

    /**
     * 获取停车位列表
     * @param parkingSpaceManagePageSearcher
     * @return
     */
    @RequestMapping(value = {"/w/parkingSpace/list"},method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView list(@ModelAttribute(value="parkingSpaceManagePageSearcher") ParkingSpaceManagePageSearcher parkingSpaceManagePageSearcher) {

        List<Map> statusList = SelectValue.getParkingSpaceStausMap();

        ModelAndView modelAndView = new ModelAndView("parkingSpaceManage/parkingSpace_list");
        modelAndView.addObject("parkingSpaceManagePageSearcher",parkingSpaceManagePageSearcher)
                    .addObject("pageObj",parkingSpaceService.searchParkingSpace(parkingSpaceManagePageSearcher))
                    .addObject("statusList",statusList);
        return modelAndView;
    }

    /**
     * 保存停车位
     * @param requestBody
     * @throws IOException
     */
    @RequestMapping(value = {"/w/parkingSpace/save1"},method = {RequestMethod.POST})
    public
    void saveParkingSpace1(@RequestBody String requestBody) throws IOException {

        ParkingSpace parkingSpace = JSON.parseObject(requestBody, ParkingSpace.class);

        parkingSpaceService.insertParkingSpace(parkingSpace);
    }

    /**
     * 保存停车位
     * @param parkingSpace
     * @throws IOException
     */
    @RequestMapping(value = {"/w/parkingSpace/save"},method = {RequestMethod.POST})
    public
    String saveParkingSpace(@ModelAttribute("parkingSpace") ParkingSpace parkingSpace, HttpServletRequest request) throws IOException {

        Integer id = parkingSpace.getId();
        boolean isAdd = (id == null);

        if (isAdd) {
            parkingSpaceService.insertParkingSpace(parkingSpace);
            saveMessage(request, "成功新增 停车位！");
        } else {
            parkingSpaceService.updateParkingSpace(parkingSpace);
            saveMessage(request, "成功修改 停车位！");
        }

        return "redirect:/w/parkingSpace/list";
    }

    /**
     * 编辑停车位
     * @return
     */
    @RequestMapping(value = {"/w/parkingSpace/manage"},method = {RequestMethod.GET})
    public
    ModelAndView manageParkingSpace(@RequestParam(value = "id", required = false) Long id,
                                    ParkingSpace parkingSpace) {

        ModelAndView modelAndView = new ModelAndView("parkingSpaceManage/parkingSpace_manage");
        if(id == null) {
            parkingSpace = new ParkingSpace();
            Map numberMap = parkingSpaceService.getParkInfoAmount(null);
            parkingSpace.setPpName((Long)numberMap.get("parkAmount") + 1);
        } else {
            parkingSpace = parkingSpaceService.getNoDeletedObj(id);
        }
        List<Map> list = SelectValue.getParkingSpaceStausMap();
        modelAndView.addObject("parkingSpace",parkingSpace)
                    .addObject("list", list);
        return modelAndView;
    }

    /**
     * 获取可用停车位
     * @return
     */
    @RequestMapping(value = "/m/parkinfo", method = RequestMethod.GET)
    public @ResponseBody
    String getParkInfo() {

        List<ParkingSpace> list = parkingSpaceService.getParkInfo("可用");

        String parks = "";
        for(ParkingSpace parkingSpace : list) {
            parks = parks + parkingSpace.getId() + ",";
        }
        Map map = new HashMap();

        map.put("name","测试停车场");
        map.put("parks",parks);

        String result = JSON.toJSONString(map);

        return result;
    }
}
