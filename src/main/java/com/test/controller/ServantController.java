package com.test.controller;

import com.test.model.Servant;
import com.test.service.ServantService;
import com.test.vo.SelectValue;
import com.test.vo.searcher.ServantManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by XinLian on 2016/3/10.
 */
@Controller("servantManageController")
@RequestMapping("/w")
public class ServantController extends BaseController{

    @Autowired
    private ServantService servantService;

    /**
     * 获取账户列表
     * @param servantManagePageSearcher
     * @return
     */
    @RequestMapping(value = "/servant/list", method ={RequestMethod.GET,RequestMethod.POST})
    public ModelAndView listServant(@ModelAttribute("servantManagePageSearcher")ServantManagePageSearcher servantManagePageSearcher) {

        List<Map> list = SelectValue.getservantStausMap();

        ModelAndView modelAndView = new ModelAndView("servantManage/servant_list");
        modelAndView.addObject("servantManagePageSearcher",servantManagePageSearcher)
                    .addObject("pageObj",servantService.searchServant(servantManagePageSearcher))
                    .addObject("list",list);
        return modelAndView;
    }

    /**
     * 编辑账号
     * @return
     */
    @RequestMapping(value = {"/servant/manage"},method = {RequestMethod.GET})
    public
    ModelAndView manageParkingSpace(@RequestParam(value = "id", required = false) Long id,
                                    Servant servant) {

        ModelAndView modelAndView = new ModelAndView("servantManage/servant_manage");
        if(id == null) {
            servant = new Servant();
        } else {
            servant = servantService.getNoDeletedObj(id);
        }
        List<Map> list = SelectValue.getservantStausMap();
        modelAndView.addObject("servant",servant)
                .addObject("list", list);
        return modelAndView;
    }
}
