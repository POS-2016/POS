package com.test.service;

import com.test.model.Reserve;
import com.test.vo.Page;
import com.test.vo.searcher.ReserveManagePageSearcher;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by XinLian on 2016/3/29.
 */
public interface ReserveService extends GenericService<Reserve, Long>  {

    /**
     * 新增订单
     * @param reserve
     * @return
     */
    int insertReserve(Reserve reserve);

    /**
     * 更新订单
     * @param reserve
     * @return
     */
    int updateReserve(Reserve reserve);

    /**
     * 根据用户Id获取当前订单列表
     * @param userId
     * @param date
     * @return
     */
    List<Reserve> getCurrentReserveById(int userId, Long date);

    /**
     * 根据用户Id获取历史订单列表
     * @param userId
     * @param date
     * @return
     */
    List<Reserve> getHistoricalReserveById(int userId, Long date);

    /**
     * 获取 reserveManagePageSearcher 搜索列表当前页对象
     * @param reserveManagePageSearcher
     * @return
     */
    Page<Reserve> searchReserve(ReserveManagePageSearcher reserveManagePageSearcher);

    /**
     * 处理过期订单
     */
    void scanOverdueReserve();

    /**
     * 取消订单
     * @param reserve
     * @return
     */
    int cancelReserve(Reserve reserve);

    /**
     * 核对订单
     * @param reserve
     * @return
     */
    int checkReserve(Reserve reserve);

    /**
     * 判断订单是否失效
     * @param reserveId
     * @return
     */
    String avaliableReserve(Long reserveId);

    int addReserve(Reserve reserve);

    /**
     * 根据日期统计订单量
     * @param date
     * @return
     */
    List<Map> countReserveByDate(String date) throws ParseException;
}
