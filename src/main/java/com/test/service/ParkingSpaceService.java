package com.test.service;

import com.test.model.ParkingSpace;
import com.test.vo.Page;
import com.test.vo.searcher.ParkingSpaceManagePageSearcher;

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
}
