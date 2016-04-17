package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.model.PersonInfo;
import com.test.service.PersonInfoService;
import com.test.vo.searcher.PersonInfoManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by XinLian on 2016/3/31.
 */
@Controller("personInfoController")
public class PersonInfoController extends BaseController {

    @Autowired
    PersonInfoService personInfoService;

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/m/personInfo/userInfo",method = RequestMethod.GET)
    public @ResponseBody
    String getPersonInfo(HttpServletRequest request) {

        String token = request.getParameter("token");
        PersonInfo personInfo = personInfoService.getPersonInfoByToken(token);
        String result = JSON.toJSONString(personInfo);
        return result;
    }

    /**
     * 新增用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/m/personInfo/newUser",method =RequestMethod.POST)
    public @ResponseBody
    String insertUser(HttpServletRequest request) {

        PersonInfo personInfo = new PersonInfo();
        personInfo.setToken(request.getParameter("token"));
        personInfo.setUsername(request.getParameter("username"));
        personInfo.setPassword(request.getParameter("password"));
        personInfo.setAvatar(request.getParameter("avatar"));
        personInfo.setPhone(request.getParameter("phone"));
        personInfo.setGander(request.getParameter("gander"));

        personInfoService.insertPersonInfo(personInfo);

        Map map = new HashMap();
        map.put("status",0);
        map.put("msg","成功");

        String result = JSON.toJSONString(map);
        return result;
    }

    /**
     * 更新用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/m/personInfo/updateUser",method =RequestMethod.POST)
    public @ResponseBody
    String updateUser(HttpServletRequest request) {

        PersonInfo personInfo = new PersonInfo();
        personInfo.setToken(request.getParameter("token"));
        personInfo.setUsername(request.getParameter("username"));
        personInfo.setPassword(request.getParameter("password"));
        personInfo.setAvatar(request.getParameter("avatar"));
        personInfo.setPhone(request.getParameter("phone"));
        personInfo.setGander(request.getParameter("gander"));

        personInfoService.updatePersonInfo(personInfo);

        Map map = new HashMap();
        map.put("status",0);
        map.put("msg","成功");

        String result = JSON.toJSONString(map);
        return result;
    }

    /**
     * 获取用户列表
     * @param personInfoManagePageSearcher
     * @return
     */
    @RequestMapping(value = "/w/personInfo/list", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView getPersonInfoList(@ModelAttribute("personInfoManagePageSearccher")PersonInfoManagePageSearcher personInfoManagePageSearcher) {

        ModelAndView modelAndView = new ModelAndView("personInfoManage/personInfo_list");
        modelAndView.addObject("personInfoManagePageSearcher",personInfoManagePageSearcher)
                    .addObject("pageObj",personInfoService.searchPersonInfo(personInfoManagePageSearcher));
        return modelAndView;
    }
}
