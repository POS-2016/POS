package com.test.controller;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gssflyaway on 16/3/30.
 */
public class HttpTest {

    public static void Login() {
        String url = "http://127.0.0.1:8080/m/logout";
        PostMethod postMethod = new PostMethod(url);
        HttpClient httpClient = new HttpClient();
        // 填入各个表单域的值
        NameValuePair[] data = {
                new NameValuePair("username", "username_1"),
                new NameValuePair("passwd", "password")
//                new NameValuePair("phone", "1111111111")
        };
        // 将表单的值放入postMethod中
        postMethod.setRequestBody(data);
        // 执行postMethod
        int statusCode = 0;
        try {
            statusCode = httpClient.executeMethod(postMethod);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // HttpClient对于要求接受后继服务的请求，象POST和PUT等不能自动处理转发
        // 301或者302
        if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
                || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
            // 从头中取出转向的地址
            Header locationHeader = postMethod.getResponseHeader("location");
            String location = null;
            if (locationHeader != null) {
                location = locationHeader.getValue();
                System.out.println("diandianLogin:" + location);
            } else {
                System.err.println("Location field value is null.");
            }
            return;
        } else {
            System.out.println(postMethod.getStatusLine());
            String str = "";
            str = postMethod.getResponseBodyAsString();
            System.out.println(str);
        }
        postMethod.releaseConnection();
        return;
    }


    public static void main(String[] args){
        Login();
    }



}
