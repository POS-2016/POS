package com.test.service;

import com.test.model.PersonInfo;
import com.test.vo.Page;
import com.test.vo.searcher.PersonInfoManagePageSearcher;

import java.util.List;

/**
 * Created by XinLian on 2016/3/30.
 */
public interface PersonInfoService extends GenericService<PersonInfo,Long> {

    /**
     * 新增用户
     * @param personInfo
     * @return
     */
    int insertPersonInfo(PersonInfo personInfo);

    /**
     * 更新用户
     * @param personInfo
     * @return
     */
    int updatePersonInfo(PersonInfo personInfo);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    List<PersonInfo> getPersonInfoByUsername(String username);

    /**
     * 根据token获取用户
     * @param token
     * @return
     */
    PersonInfo getPersonInfoByToken(String token);

    /**
     * 获取 personInfoManagePageSearcher 搜索列表当前页对象
     * @param personInfoManagePageSearcher
     * @return
     */
    Page<PersonInfo> searchPersonInfo(PersonInfoManagePageSearcher personInfoManagePageSearcher);
}
