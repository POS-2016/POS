package com.test.dao;

import com.test.model.PersonInfo;

import java.util.List;

/**
 * Created by XinLian on 2016/3/30.
 */
public interface PersonInfoDao extends GenericDao<PersonInfo,Long>{

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    List<PersonInfo> getPersonInfoByUsername(String username);

    /**
     * 根据token查找用户
     * @param token
     * @return
     */
    PersonInfo getPersonInfoByToken(String token);

    /**
     * 根据手机查找用户
     * @param phone
     * @return
     */
    PersonInfo getPersonInfoByPhone(String phone);

}
