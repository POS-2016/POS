package com.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XinLian on 2016/3/10.
 */
public class BaseController implements ServletContextAware {

    public final Logger logger = LoggerFactory.getLogger(getClass().getName());

    public static final String MESSAGES_KEY = "successMsg";
    public static final String ERROR_KEY = "errorMsg";

    private ServletContext servletContext;

    /**
     * 这个方法的目的是为了减少库查询
     *
     * 得到当前缓存的回话用户，很多信息可能还是老的;          *
     * 如果要通过用户取最新信息，需要调用上面的getCurrentSessionObject()方法
     *
     * @return
     */

    @SuppressWarnings("unchecked")
    public void saveMessage(HttpServletRequest request, String msg) {
        List<String> messages = (List<String>) request.getSession().getAttribute(MESSAGES_KEY);

        if (messages == null) {
            messages = new ArrayList<String>();
        }

        messages.add(msg);
        request.getSession().setAttribute(MESSAGES_KEY, messages);
    }

    @SuppressWarnings("unchecked")
    public void saveError(HttpServletRequest request, String error) {
        List<String> errors = (List<String>) request.getSession().getAttribute(ERROR_KEY);
        if (errors == null) {
            errors = new ArrayList<String>();
        }
        errors.add(error);
        request.getSession().setAttribute(ERROR_KEY, errors);
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


    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

//    //以json格式返回
//    protected void sendResponseAsJson(HttpServletResponse response,
//                                      String data) {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            out.append(data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                out.close();
//            }
//        }
//    }
}
