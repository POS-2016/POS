package com.test.service.impl;

import com.test.dao.ParkingSpaceDao;
import com.test.dao.ReserveDao;
import com.test.model.ParkingSpace;
import com.test.model.Reserve;
import com.test.service.ReserveService;
import com.test.vo.Page;
import com.test.vo.SelectValue;
import com.test.vo.searcher.ReserveManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
            ParkingSpace parkingSpace = parkingSpaceDao.getNoDeletedObj(spaceId);
            parkingSpace.setStatus("可用");
            parkingSpaceDao.update(parkingSpace);
        }
    }

    @Override
    public int cancelReserve(Reserve reserve) {

        Long spaceId = reserve.getSpaceId();
        ParkingSpace parkingSpace = parkingSpaceDao.getNoDeletedObj(spaceId);
        parkingSpace.setStatus("可用");
        parkingSpaceDao.update(parkingSpace);
        reserve.setStatus(1);
        return reserveDao.update(reserve);
    }

    @Override
    public int checkReserve(Reserve reserve) {
        Long spaceId = reserve.getSpaceId();
        ParkingSpace parkingSpace = parkingSpaceDao.getNoDeletedObj(spaceId);
        parkingSpace.setStatus("正在使用");
        parkingSpaceDao.update(parkingSpace);

        reserve.setStatus(1);
        return reserveDao.update(reserve);
    }

    @Override
    public String avaliableReserve(Long reserveId) {

        Reserve reserve = reserveDao.getNoDeletedObj(reserveId);

        if(reserve.getOrderTime() < System.currentTimeMillis() || reserve.getStatus() == 1) {

            return "0";
        } else {
            return "1";
        }
    }

    @Override
    public int addReserve(Reserve reserve) {
        return reserveDao.insert(reserve);
    }

    @Override
    public List<Map> countReserveByDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<Map> list = SelectValue.getDateTime(date);
        List<Map> resultList = new ArrayList<Map>();
        for(Map map : list) {
            String start = (String)map.get("startTime");
            String end = (String)map.get("endTime");
            Long startTime = format.parse(start).getTime();
            Long endTime = format.parse(end).getTime();

            Map resultMap = reserveDao.countReserveByDate(startTime,endTime);
            resultList.add(resultMap);
        }
        return resultList;
    }
}
