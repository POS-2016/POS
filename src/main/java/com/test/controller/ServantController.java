package com.test.controller;

import com.test.service.ServantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by XinLian on 2016/3/10.
 */
@Controller("servantManageController")
@RequestMapping("/manage/servant")
public class ServantController extends BaseController{

    @Autowired
    private ServantService servantService;

    @RequestMapping(value = "/list", method ={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView listServant() {
        return new ModelAndView("servantManage/servant_list")
                .addObject("list",servantService.listAll());

    }
}
