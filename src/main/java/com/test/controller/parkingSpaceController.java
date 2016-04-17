package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.model.ParkingSpace;
import com.test.service.ParkingSpaceService;
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

        Map map1 = new HashMap();
        Map map2 = new HashMap();
        Map map3 = new HashMap();

        map1.put("key","可用");
        map2.put("key","已预定");
        map3.put("key","正在使用");

        List<Map> statusList = new ArrayList<Map>();

        statusList.add(map1);
        statusList.add(map2);
        statusList.add(map3);

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
    @RequestMapping(value = {"/w/parkingSpace/save"},method = {RequestMethod.POST})
    public
    void saveParkingSpace(@RequestBody String requestBody) throws IOException {

        ParkingSpace parkingSpace = JSON.parseObject(requestBody, ParkingSpace.class);

        parkingSpaceService.insertParkingSpace(parkingSpace);
    }

    /**
     * 编辑停车位
     * @return
     */
    @RequestMapping(value = {"/w/parkingSpace/manage"},method = {RequestMethod.GET})
    public
    ModelAndView manageParkingSpace() {

        ModelAndView modelAndView = new ModelAndView("parkingSpaceManage/parkingSpace_manage");
        List<Map> list = new ArrayList<Map>();
        for (int i = 0; i < 10; i++) {
            Map map = new HashMap();
            map.put("key",i);
            list.add(map);
        }
        modelAndView.addObject("list",list);
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
