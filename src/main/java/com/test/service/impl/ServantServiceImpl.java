package com.test.service.impl;

import com.test.dao.ServantDao;
import com.test.model.Servant;
import com.test.service.ServantService;
import com.test.vo.PasswordEncoder;
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

    /**
     * 新增账号
     * @param servant
     * @return
     */
    @Override
    public long insertServant(Servant servant) {
        servant.setStatus(1);
        servant.setPassword(PasswordEncoder.encode(servant.getPassword(),servant.getUsername()));
        servantDao.insert(servant);
        return servant.getId();
    }

    /**
     * 更新密码||删除账号
     * @param servant
     * @return
     */
    @Override
    public int updateServant(Servant servant) {
        return servantDao.update(servant);
    }

    /**
     * 根据用户名搜索账号
     * @param servantUsername
     * @return
     */
    @Override
    public Servant getServantByUsername(String servantUsername) {
        return servantDao.getServantByUsername(servantUsername);
    }
}
