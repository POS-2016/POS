package com.test.dao;

import com.test.model.Servant;

/**
 * Created by XinLian on 2016/3/9.
 */
public interface ServantDao extends GenericDao<Servant,Long>{

    /**
     * 根据用户名到数据库查询用户
     *
     * @param servantUsername
     * @return
     */
    Servant getServantByUsername(final String servantUsername);

    /*
    *
    *
    * */
}
