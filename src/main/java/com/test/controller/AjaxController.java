package com.test.controller;

import com.test.utils.ResponseUtil;
import com.test.vo.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * Created by XinLian on 2016/4/15.
 */
@Controller("ajaxController")
public class AjaxController extends BaseController{

    /**
     * 校验是否为空或者是否为数字
     * @param response
     * @param id
     */
    @RequestMapping(value = "/w/ajax_number",method = RequestMethod.POST)
    public void ajaxCheckNumber(HttpServletResponse response, @RequestParam("id") String id) {
        if(id == null || id.equals("")) {
            ResponseUtil.renderJsonResult(response, new JsonResult(true,
                    "success", null));
        } else {
            Pattern pattern = Pattern.compile("[0-9]*");
            boolean flag = pattern.matcher(id).matches();
            if(flag) {
                ResponseUtil.renderJsonResult(response, new JsonResult(true,
                        "success", null));
            } else {
                ResponseUtil.renderJsonResult(response, new JsonResult(false,
                        "fail", null));
            }
        }
    }
}
