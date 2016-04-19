package com.test.dao;

import com.test.model.Reserve;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取过期订单
     * @param currentTime
     * @return
     */
    List<Reserve> getOverdueReserve(@Param("currentTime") long currentTime);

    /**
     * 根据日期统计订单量
     * @param startTime
     * @param endTime
     * @return
     */
    Map countReserveByDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
}
