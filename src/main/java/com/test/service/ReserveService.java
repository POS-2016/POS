package com.test.service;

import com.test.model.Reserve;
import com.test.vo.Page;
import com.test.vo.searcher.ReserveManagePageSearcher;

import java.util.Date;
import java.util.List;

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
}
