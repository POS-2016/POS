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

    @RequestMapping(value = {"/m/login"}, method = {RequestMethod.POST})
    public void mobileLogin(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        Gson gson = new Gson();
        List<PersonInfo> personInfos = personInfoDao.getPersonInfoByUsername(userName);
        int flag = checkQuality(passwd, personInfos);
        ArrayList<LoginReturnMsg> result = new ArrayList<LoginReturnMsg>();
        if(flag > 0){
            LoginReturnMsg loginReturnMsg = new LoginReturnMsg();
            loginReturnMsg.setStatus("0");
            loginReturnMsg.setMsg(tokenGen());
            result.add(loginReturnMsg);
            //更新token?????
            PersonInfo personInfo = personInfos.get(flag-1);
            personInfoDao.update(personInfo);
        }else{
            LoginReturnMsg loginReturnMsg = new LoginReturnMsg();
            loginReturnMsg.setStatus("1");
            loginReturnMsg.setMsg("Login failed!");
            result.add(loginReturnMsg);
        }
        String json = gson.toJson(result);
        sendResponseAsJson(response, json);
    }

    @RequestMapping(value = {"/m/register"}, method = {RequestMethod.POST})
    public void mobileRegister(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        String phone = request.getParameter("phone");
        Gson gson = new Gson();
        List<PersonInfo> personInfos = personInfoDao.getPersonInfoByUsername(userName);
        PersonInfo personInfo = personInfoDao.getPersonInfoByPhone(phone);
        ArrayList<LoginReturnMsg> result = new ArrayList<LoginReturnMsg>();
        if (personInfo != null){
            LoginReturnMsg loginReturnMsg = new LoginReturnMsg();
            loginReturnMsg.setStatus("1");
            loginReturnMsg.setMsg("Your phone number has been used!");
            result.add(loginReturnMsg);
        }else {
            int flag = 0;
            for (int i=0; i<personInfos.size(); i++){
                if (userName.equals(personInfos.get(i).getUsername())){
                    flag = 1;
                    break;
                }
            }
            if (flag == 1){
                LoginReturnMsg loginReturnMsg = new LoginReturnMsg();
                loginReturnMsg.setStatus("1");
                loginReturnMsg.setMsg("Existed Username!");
                result.add(loginReturnMsg);
            }else {
                LoginReturnMsg loginReturnMsg = new LoginReturnMsg();
                loginReturnMsg.setStatus("0");
                loginReturnMsg.setMsg("Register sucessfully!");
                result.add(loginReturnMsg);
                //把记录加进数据库
                PersonInfo personInfo1 = new PersonInfo();
                personInfo1.setUsername(userName);
                personInfo1.setPhone(phone);
                personInfoDao.insert(personInfo1);
            }
        }
        String json = gson.toJson(result);
        sendResponseAsJson(response, json);
    }

    private int checkQuality(String passwd, List<PersonInfo> personInfos){
        if(personInfos != null){
            int flag = 0;
            int count = 0;
            for (int i=0; i<personInfos.size(); i++) {
                System.out.println(personInfos.get(i).getUsername());
                System.out.println(personInfos.get(i).getPassword());
                if (passwd.equals(personInfos.get(i).getPassword())) {
                    flag = 1;
                    count = i+1;
                    break;
                } else continue;
            }
            if (flag == 1) return count;
            else return 0;
        }else return 0;
    }

    private String tokenGen(){
        Random random = new Random();
        while (true){
            long token = nextLong(random, 999999999);
            if (token > 100000000)
                return Long.toString(token);
        }
    }

    private long nextLong(Random rng, long n) {
        // error checking and 2^x checking removed for simplicity.
        long bits, val;
        do {
            bits = (rng.nextLong() << 1) >>> 1;
            val = bits % n;
        } while (bits-val+(n-1) < 0L);
        return val;
    }

    //以json格式返回
    protected void sendResponseAsJson(HttpServletResponse response,
                                      String data) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
