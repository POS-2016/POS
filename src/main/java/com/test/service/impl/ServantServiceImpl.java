package com.test.service.impl;

import com.test.dao.ServantDao;
import com.test.model.Servant;
import com.test.service.ServantService;
import com.test.vo.Page;
import com.test.vo.PasswordEncoder;
import com.test.vo.searcher.ServantManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XinLian on 2016/3/9.
 */
@Service("servantService")
public class ServantServiceImpl extends GenericServiceImpl<Servant, Long> implements ServantService{

    @Autowired
    private ServantDao servantDao;

    @Autowired
    public ServantServiceImpl(ServantDao servantDao) {
        super(servantDao);
        this.servantDao = servantDao;
    }

    @Override
    public long insertServant(Servant servant) {
        servant.setStatus(1);
        servant.setPassword(PasswordEncoder.encode(servant.getPassword(),servant.getUsername()));
        servantDao.insert(servant);
        return servant.getId();
    }

    @Override
    public int updateServant(Servant servant) {
        return servantDao.update(servant);
    }

    @Override
    public Servant getServantByUsername(String servantUsername) {
        return servantDao.getServantByUsername(servantUsername);
    }

    @Override
    public Page<Servant> searchServant(ServantManagePageSearcher servantManagePageSearcher) {
        servantManagePageSearcher.setPageSize(10);
        servantManagePageSearcher.setResult(servantDao.searchPage(servantManagePageSearcher));
        return servantManagePageSearcher;
    }
}
