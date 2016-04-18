package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.test.dao.ParkingSpaceDao;
import com.test.model.ParkingSpace;
import com.test.model.ParkingSpaceStatus;
import com.test.service.ParkingSpaceService;
import com.test.vo.searcher.ParkingSpaceManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    ParkingSpaceDao parkingSpaceDao;

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

    @RequestMapping(value = {"/w/parkingSpace/chart"},method = {RequestMethod.GET})
    public ModelAndView chartParkingSpace(){
        ModelAndView modelAndView = new ModelAndView("parkingSpaceManage/parkingSpace_charts");
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

    /**
     * 获取停车位状态及个数
     * @return
     */
    @RequestMapping(value = {"w/parkingSpace/status"}, method = {RequestMethod.GET})
    public void statusParkingSpace(HttpServletRequest request, HttpServletResponse response){
        List<ParkingSpaceStatus> listStatus = new ArrayList<>();
        ParkingSpaceStatus status1 = new ParkingSpaceStatus();
        ParkingSpaceStatus status2 = new ParkingSpaceStatus();
        ParkingSpaceStatus status3 = new ParkingSpaceStatus();
        status1.setStatus("可用"); status1.setNumber(0);
        status2.setStatus("已预订"); status2.setNumber(0);
        status3.setStatus("正在使用"); status3.setNumber(0);
        listStatus.add(0, status1);
        listStatus.add(1, status2);
        listStatus.add(2, status3);

        List<ParkingSpace> list = parkingSpaceDao.listAll();
        for (int i=0; i<list.size(); i++){
            if ("可用".equals(list.get(i).getStatus())){
                listStatus.get(0).setNumber(listStatus.get(0).getNumber() + 1);
            }
            if ("已预订".equals(list.get(i).getStatus())){
                listStatus.get(1).setNumber(listStatus.get(1).getNumber() + 1);
            }
            if ("正在使用".equals(list.get(i).getStatus())){
                listStatus.get(2).setNumber(listStatus.get(2).getNumber() + 1);
            }
        }

        Gson gson = new Gson();
        String json = gson.toJson(listStatus);
        sendResponseAsJson(response, json);
    }
}
