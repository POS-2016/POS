package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.module.sitemesh.parser.HTMLPageParser;
import com.test.model.ParkingSpace;
import com.test.model.PersonInfo;
import com.test.model.Reserve;
import com.test.service.ParkingSpaceService;
import com.test.service.PersonInfoService;
import com.test.service.ReserveService;
import com.test.utils.ObjectToMap;
import com.test.vo.searcher.ReserveManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;

/**
 * Created by XinLian on 2016/3/29.
 */
@Controller("reserveController")
public class ReserveController extends BaseController {

    @Autowired
    ReserveService reserveService;
    @Autowired
    PersonInfoService personInfoService;
    @Autowired
    ParkingSpaceService parkingSpaceService;

    /**
     * 根据token获取当前订单
     * @param request
     * @return
     */
    @RequestMapping(value = "/m/current_reserve", method ={RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody
    String getCurrentReserveById(HttpServletRequest request) {

        String token = request.getParameter("token");
        PersonInfo personInfo = personInfoService.getPersonInfoByToken(token);
        List<Reserve> list = reserveService.getCurrentReserveById(personInfo.getUserId(),System.currentTimeMillis());
        List<Map> resultMap = ObjectToMap.reserveToMap(list);
        String result = JSON.toJSONString(resultMap);
        return result;
    }

    /**
     * 根据token获取历史订单
     * @param request
     * @return
     */
    @RequestMapping(value = "/m/old_reserve", method ={RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody
    String getHistoricalReserveById(HttpServletRequest request) {

        String token = request.getParameter("token");
        PersonInfo personInfo = personInfoService.getPersonInfoByToken(token);
        List<Reserve> list = reserveService.getHistoricalReserveById(personInfo.getUserId(), System.currentTimeMillis());
        List<Map> resultMap = ObjectToMap.reserveToMap(list);
        String result = JSON.toJSONString(resultMap);
        return result;
    }

    /**
     * 新增订单
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/m/reserve", method = {RequestMethod.POST})
    public @ResponseBody
    String reserve(HttpServletRequest request) throws ParseException {
        String token = request.getParameter("token");
        Double fee = Double.valueOf(request.getParameter("fee"));
        String parks = request.getParameter("parks");
        Long time = Long.valueOf(request.getParameter("time"));

        PersonInfo personInfo = personInfoService.getPersonInfoByToken(token);
        Reserve reserve = new Reserve();
        reserve.setUserId(personInfo.getUserId());
        reserve.setOrderTime(time);
        reserve.setSpaceId(Long.valueOf(parks));
        reserve.setFee(fee);

        reserveService.insertReserve(reserve);

        Map map = new HashMap();
        map.put("status",0);
        map.put("msg","成功");

        String result = JSON.toJSONString(map);
        return result;
    }

    /**
     * 订单延期
     * @param request
     * @return
     */
    @RequestMapping(value = "/m/current_reserve/delay",method = RequestMethod.GET)
    public @ResponseBody
    String delayReserve(HttpServletRequest request) {

        long id = Long.valueOf(request.getParameter("id"));
        String token = request.getParameter("token");
        Long orderTime = Long.valueOf(request.getParameter("time"));
        Double fee = Double.valueOf(request.getParameter("fee"));

        Reserve reserve = reserveService.getNoDeletedObj(id);
        reserve.setFee(fee + reserve.getFee());
        reserve.setOrderTime(orderTime);

        reserveService.updateReserve(reserve);

        Map map = new HashMap();
        map.put("status",0);
        map.put("msg","延期预约成功");

        String result = JSON.toJSONString(map);

        return result;
    }

    /**
     * 取消订单
     * @param request
     * @return
     */
    @RequestMapping(value = "/m/current_reserve/cancel",method = RequestMethod.GET)
    public @ResponseBody
    String cancelReserve(HttpServletRequest request) {

        long id = Long.valueOf(request.getParameter("id"));
        String token = request.getParameter("token");

        Reserve reserve = reserveService.getNoDeletedObj(id);
        reserveService.cancelReserve(reserve);

        Map map = new HashMap();
        map.put("status",0);
        map.put("msg","取消预约成功");

        String result = JSON.toJSONString(map);

        return result;
    }

    /**
     * 核对订单
     * @param request
     * @return
     */
    @RequestMapping(value = "w/checkReserve",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    String checkReserve(HttpServletRequest request){
        long id = Long.valueOf(request.getParameter("id"));
        String token = request.getParameter("token");

        Reserve reserve = reserveService.getNoDeletedObj(id);
        reserveService.checkReserve(reserve);

        Map map = new HashMap();
        map.put("status",0);
        map.put("msg","成功");

        String result = JSON.toJSONString(map);

        return result;
    }

    /**
     * 获取订单列表
     * @param reserveManagePageSearcher
     * @return
     */
    @RequestMapping(value = {"/w/reserve/list"},method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView list(@ModelAttribute(value="reserveManagePageSearcher") ReserveManagePageSearcher reserveManagePageSearcher) {

        ModelAndView modelAndView = new ModelAndView("reserveManage/reserve_list");
        modelAndView.addObject("reserveManagePageSearcher", reserveManagePageSearcher)
                .addObject("pageObj", reserveService.searchReserve(reserveManagePageSearcher));
        return modelAndView;
    }

}
