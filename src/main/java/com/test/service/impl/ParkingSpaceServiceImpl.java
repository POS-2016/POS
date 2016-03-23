package com.test.service.impl;

import com.test.dao.ParkingSpaceDao;
import com.test.model.ParkingSpace;
import com.test.service.ParkingSpaceService;
import com.test.vo.Page;
import com.test.vo.searcher.ParkingSpaceManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XinLian on 2016/3/13.
 */
@Service("parkingSpaceService")
public class ParkingSpaceServiceImpl extends GenericServiceImpl<ParkingSpace, Long> implements ParkingSpaceService{

    @Autowired
    ParkingSpaceDao parkingSpaceDao;

    @Autowired
    public ParkingSpaceServiceImpl(ParkingSpaceDao parkingSpaceDao) {
        super(parkingSpaceDao);
        this.parkingSpaceDao = parkingSpaceDao;
    }

    @Override
    public long insertParkingSpace(ParkingSpace parkingSpace) {
        int id = parkingSpaceDao.insert(parkingSpace);
        return id;
    }

    @Override
    public Page<ParkingSpace> searchParkingSpace(ParkingSpaceManagePageSearcher parkingSpaceManagePageSearcher) {
        parkingSpaceManagePageSearcher.setPageSize(10);
        parkingSpaceManagePageSearcher.setResult(parkingSpaceDao.searchPage(parkingSpaceManagePageSearcher));
        return parkingSpaceManagePageSearcher;
    }
}
