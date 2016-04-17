package com.test.service.impl;

import com.test.dao.ReserveDao;
import com.test.model.Reserve;
import com.test.service.ReserveService;
import com.test.vo.Page;
import com.test.vo.searcher.ReserveManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by XinLian on 2016/3/29.
 */
@Service("reserveService")
public class ReserveServiceImpl extends GenericServiceImpl<Reserve,Long> implements ReserveService {

    @Autowired
    ReserveDao reserveDao;

    @Autowired
    public ReserveServiceImpl(ReserveDao reserveDao) {
        super(reserveDao);
    }

    @Override
    public int insertReserve(Reserve reserve) {
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
}
