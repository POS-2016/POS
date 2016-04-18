package com.test.service.impl;

import com.test.dao.ParkingSpaceDao;
import com.test.dao.ReserveDao;
import com.test.model.ParkingSpace;
import com.test.model.Reserve;
import com.test.service.ReserveService;
import com.test.vo.Page;
import com.test.vo.searcher.ReserveManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by XinLian on 2016/3/29.
 */
@Service("reserveService")
@Component
public class ReserveServiceImpl extends GenericServiceImpl<Reserve,Long> implements ReserveService {

    @Autowired
    ReserveDao reserveDao;
    @Autowired
    ParkingSpaceDao parkingSpaceDao;

    @Autowired
    public ReserveServiceImpl(ReserveDao reserveDao) {
        super(reserveDao);
    }

    @Override
    public int insertReserve(Reserve reserve) {

        Long spaceId = reserve.getSpaceId();
        ParkingSpace parkingSpace = parkingSpaceDao.getNoDeletedObj(spaceId);
        parkingSpace.setStatus("已预订");
        parkingSpaceDao.update(parkingSpace);

        return reserveDao.insert(reserve);
    }

    @Override
    public int updateReserve(Reserve reserve) {
        return reserveDao.update(reserve);
    }

    @Override
    public List<Reserve> getCurrentReserveById(int userId, Long date) {
        List<Reserve> list = reserveDao.getCurrentReserveById(userId,date);
        return list;
    }

    @Override
    public List<Reserve> getHistoricalReserveById(int userId, Long date) {
        List<Reserve> list = reserveDao.getHistoricalReserveById(userId,date);
        return list;
    }

    @Override
    public Page<Reserve> searchReserve(ReserveManagePageSearcher reserveManagePageSearcher) {

        reserveManagePageSearcher.setPageSize(10);
        reserveManagePageSearcher.setResult(reserveDao.searchPage(reserveManagePageSearcher));
        return reserveManagePageSearcher;
    }

    @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
    @Override
    public void scanOverdueReserve() {
        long currentTime = System.currentTimeMillis();
        List<Reserve> list = reserveDao.getOverdueReserve(currentTime);

        for(Reserve reserve : list) {
            Long spaceId = reserve.getSpaceId();
            ParkingSpace parkingSpace = parkingSpaceDao.get(spaceId);
            parkingSpace.setStatus("可用");
            parkingSpaceDao.update(parkingSpace);
        }
    }

    @Override
    public int cancelReserve(Reserve reserve) {

        Long spaceId = reserve.getSpaceId();
        ParkingSpace parkingSpace = parkingSpaceDao.get(spaceId);
        parkingSpace.setStatus("可用");
        parkingSpaceDao.update(parkingSpace);
        reserve.setStatus(1);
        return reserveDao.update(reserve);
    }

    @Override
    public int checkReserve(Reserve reserve) {
        Long spaceId = reserve.getSpaceId();
        ParkingSpace parkingSpace = parkingSpaceDao.get(spaceId);
        parkingSpace.setStatus("正在使用");
        parkingSpaceDao.update(parkingSpace);

        reserve.setStatus(1);
        return reserveDao.update(reserve);
    }
}
