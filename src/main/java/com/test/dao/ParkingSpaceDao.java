package com.test.dao;

import com.test.model.ParkingSpace;

import java.util.List;

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

}
