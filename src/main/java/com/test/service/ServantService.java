package com.test.service;

import com.test.model.Servant;

/**
 * Created by XinLian on 2016/3/9.
 */
public interface ServantService extends GenericService<Servant, Long> {

    /**
     * 添加 servant
     *
     * @param servant
     * @return
     */
    long insertServant(Servant servant);

    /**
     * 修改 servant
     *
     * @param servant
     * @return
     */
    int updateServant(Servant servant);

    /**
     * 根据用户名到数据库查询用户
     *
     * @param servantUsername
     * @return
     */
    Servant getServantByUsername(final String servantUsername);




}
