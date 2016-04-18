package com.test.dao;

import com.test.model.ParkingSpace;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * Created by XinLian on 2016/3/13.
 */
public interface ParkingSpaceDao extends GenericDao<ParkingSpace,Long>{

    /**
     * 插入
     * @param parkingSpace
     * @return
     */
    int insert(ParkingSpace parkingSpace);

    /**
     * 获取可用停车位数量
     * @return
     */
    Map getParkInfoAmount(@Param("status") String status);

    /**
     * 获取可用停车位信息
     * @return
     */
    List<ParkingSpace> getParkInfo(String status);
}
