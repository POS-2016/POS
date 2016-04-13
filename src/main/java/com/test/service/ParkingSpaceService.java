package com.test.service;

import com.test.model.ParkingSpace;
import com.test.vo.Page;
import com.test.vo.searcher.ParkingSpaceManagePageSearcher;

import java.util.List;
import java.util.Map;

/**
 * Created by XinLian on 2016/3/13.
 */
public interface ParkingSpaceService extends GenericService<ParkingSpace, Long> {

    /**
     * 添加 parkingSpace
     *
     * @param parkingSpace
     * @return
     */
    long insertParkingSpace(ParkingSpace parkingSpace);

    /**
     * 获取 parkingSpaceManagePageSearcher 搜索列表当前页对象
     *
     * @param parkingSpaceManagePageSearcher
     * @return
     */
    Page<ParkingSpace> searchParkingSpace(ParkingSpaceManagePageSearcher parkingSpaceManagePageSearcher);

    /**
     * 获取可用停车位数量
     * @return
     */
    Map getParkInfoAmount(String status);

    /**
     * 获取可用停车位信息
     * @return
     */
    List<ParkingSpace> getParkInfo(String status);
}
