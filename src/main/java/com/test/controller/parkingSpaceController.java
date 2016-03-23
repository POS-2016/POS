package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.model.ParkingSpace;
import com.test.service.ParkingSpaceService;
import com.test.vo.searcher.ParkingSpaceManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XinLian on 2016/3/13.
 */
@Controller("parkingSpaceManageController")
@RequestMapping("/manage/parkingSpace")
public class parkingSpaceController extends BaseController{

    @Autowired
    ParkingSpaceService parkingSpaceService;

    @RequestMapping(value = {"/list"},method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView list(@ModelAttribute(value="parkingSpaceManagePageSearcher") ParkingSpaceManagePageSearcher parkingSpaceManagePageSearcher) {
        ModelAndView modelAndView = new ModelAndView("parkingSpaceManage/parkingSpace_list");
        modelAndView.addObject("parkingSpaceManagePageSearcher",parkingSpaceManagePageSearcher)
                    .addObject("pageObj",parkingSpaceService.searchParkingSpace(parkingSpaceManagePageSearcher));
        return modelAndView;
    }

    @RequestMapping(value = {"/save"},method = {RequestMethod.POST})
    public
    void saveParkingSpace(@RequestBody String requestBody) throws IOException {

        ParkingSpace parkingSpace = JSON.parseObject(requestBody, ParkingSpace.class);

        parkingSpaceService.insertParkingSpace(parkingSpace);
    }

    @RequestMapping(value = {"/manage"},method = {RequestMethod.GET})
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
}
