package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.test.model.ParkingSpace;
import com.test.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by XinLian on 2016/3/12.
 */
@Controller
@RequestMapping("/manage")
public class TestController {

    @Autowired
    ParkingSpaceService parkingSpaceService;

    @RequestMapping(value = {"/table"},method = {RequestMethod.GET})
    public ModelAndView test() {
        List<ParkingSpace> list = parkingSpaceService.listAll();
        String str = JSON.toJSONString(list);
        ModelAndView modelAndView = new ModelAndView("table");
        modelAndView.addObject("list",str);
        return modelAndView;
    }

    @RequestMapping(value = {"/test"},method = {RequestMethod.GET})
    public ModelAndView test1() {
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }

    @RequestMapping(value = {"/table1"},method = {RequestMethod.GET})
    public ModelAndView table1() {
        ModelAndView modelAndView = new ModelAndView("table1");
        return modelAndView;
    }
}
