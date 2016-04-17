package com.test.controller;

import com.google.gson.Gson;
import com.test.dao.ServantDao;
import com.test.model.LoginReturnMsg;
import com.test.model.Servant;
import com.test.vo.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;


/**
 * Created by gssflyaway on 16/3/29.
 */
@Controller
public class ApiController extends BaseController {
    @Autowired
    ServantDao servantDao;

    @RequestMapping(value = "/m/login", method = {RequestMethod.POST})
    public void loginApi(HttpServletRequest request, HttpServletResponse response){
        System.out.println("haaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String userName = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        Gson gson = new Gson();
        Servant servant = new Servant();
        servant = servantDao.getServantByUsername(userName);
        boolean flag = checkQuality(passwd, servant);
        String[] result = new String[2];
        if(flag == true){
            result[0] = "0";
            result[1] = String.valueOf(Math.random());
        }else{
            result[0] = tokenGen();
            result[1] = "Login failed!";
            System.out.println(result[0]);
            System.out.println(result[1]);
        }
        String json = gson.toJson(result);
        sendResponseAsJson(response, json);
    }

    private boolean checkQuality(String passwd, Servant servant){
        if(servant != null){
            if(PasswordEncoder.encode(String.valueOf(passwd), servant.getUsername()).equals(servant.getPassword())){
                return true;
            }else
                return false;
        }else return false;
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
}
