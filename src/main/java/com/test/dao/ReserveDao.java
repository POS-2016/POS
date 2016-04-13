package com.test.dao;

import com.test.model.Reserve;

import java.util.List;

/**
 * Created by XinLian on 2016/3/29.
 */
public interface ReserveDao extends GenericDao<Reserve,Long> {

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
}