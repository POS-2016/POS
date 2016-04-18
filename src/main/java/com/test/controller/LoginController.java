package com.test.controller;

import com.google.gson.Gson;
import com.test.dao.PersonInfoDao;
import com.test.dao.ServantDao;
import com.test.model.LoginReturnMsg;
import com.test.model.PersonInfo;
import com.test.model.Servant;
import com.test.vo.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by XinLian on 2016/3/10.
 */
@Controller("LoginController")
@RequestMapping("/general")
public class LoginController{

    @Autowired
    ServantDao servantDao;

    @Autowired
    PersonInfoDao personInfoDao;

    @RequestMapping(value = {"/login"},method = {RequestMethod.GET})
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("errorMsg", "");
        return modelAndView;
    }

    @RequestMapping(value = {"/login"},method = {RequestMethod.POST})
    public ModelAndView checkLogin(String username,String password,HttpServletRequest request) {

        Servant servant = servantDao.getServantByUsername(username);
        ModelAndView modelAndView = new ModelAndView("redirect:/manage/parkingSpace/list");

        if(servant == null) {
            System.out.print("用户名或密码错误!");
            modelAndView.setViewName("login");
            modelAndView.addObject("errorMsg", "用户名或密码错误");
            return modelAndView;
        }else if(!PasswordEncoder.encode(String.valueOf(password), servant.getUsername()).equals(servant.getPassword())) {
            System.out.print("用户名或密码错误!");
            System.out.println(PasswordEncoder.encode(String.valueOf(password), servant.getUsername()));
            modelAndView.setViewName("login");
            modelAndView.addObject("errorMsg", "用户名或密码错误");
            return modelAndView;
        }

        HttpSession session = request.getSession();
        session.setAttribute("username",username.toString());
        session.setAttribute("userId",servant.getId());

        if(session.getAttribute("lastUri") != null ) {
            String uri = session.getAttribute("lastUri").toString();
            session.removeAttribute("lastUri");
            modelAndView.setViewName("redirect:" + uri);
            session.setAttribute("user", servant);
        }

        return modelAndView;
    }

    @RequestMapping(value = {"/logout"}, method = {RequestMethod.GET})
    public ModelAndView logout(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.invalidate();

        ModelAndView modelAndView = new ModelAndView("redirect:/general/login");
        modelAndView.addObject("errorMsg", "");
        return modelAndView;
    }


}
