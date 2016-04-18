package com.test.controller;

import com.google.gson.Gson;
import com.test.dao.PersonInfoDao;
import com.test.dao.ServantDao;
import com.test.model.LoginReturnMsg;
import com.test.model.PersonInfo;
import com.test.model.Servant;
import com.test.vo.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


/**
 * Created by gssflyaway on 16/3/29.
 */
@Controller
public class ApiController extends BaseController {
    @Autowired
    ServantDao servantDao;

    @Autowired
    PersonInfoDao personInfoDao;

    @RequestMapping(value = {"/m/login"}, method = {RequestMethod.POST})
    public void mobileLogin(HttpServletRequest request, HttpServletResponse response){
        try {
            String userName = request.getParameter("username");
            String passwd = request.getParameter("passwd");
            Gson gson = new Gson();
            List<PersonInfo> personInfos = personInfoDao.getPersonInfoByUsername(userName);
            System.out.println(personInfos.size());
            int flag = checkQuality(passwd, personInfos);
            ArrayList<LoginReturnMsg> result = new ArrayList<LoginReturnMsg>();
            if(flag > 0){
                LoginReturnMsg loginReturnMsg = new LoginReturnMsg();
                loginReturnMsg.setStatus("0");
                loginReturnMsg.setMsg(tokenGen());
                result.add(loginReturnMsg);
                //更新token?????
                personInfos.get(0).setToken(loginReturnMsg.getMsg());
                PersonInfo personInfo = personInfos.get(0);
                personInfoDao.update(personInfo);
            }else{
                LoginReturnMsg loginReturnMsg = new LoginReturnMsg();
                loginReturnMsg.setStatus("1");
                loginReturnMsg.setMsg("Login failed!");
                result.add(loginReturnMsg);
            }
            String json = gson.toJson(result.get(0));
            sendResponseAsJson(response, json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = {"m/logout"}, method = {RequestMethod.POST})
    public  void outLogin(HttpServletRequest request, HttpServletResponse response){
        String token = request.getParameter("token");
        PersonInfo personInfo = personInfoDao.getPersonInfoByToken(token);
        if (personInfo == null) return;
        else personInfo.setToken("");
        personInfoDao.update(personInfo);
        Map<String, String> map = new HashMap<>();
        map.put("status", "");
        map.put("msg", "success");
        Gson gson = new Gson();
        String json = gson.toJson(map);
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
                personInfo1.setPassword(passwd);
                personInfo1.setPhone(phone);
                personInfoDao.insert(personInfo1);
            }
        }
        String json = gson.toJson(result.get(0));
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
