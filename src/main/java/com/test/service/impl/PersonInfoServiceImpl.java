package com.test.service.impl;

import com.test.dao.PersonInfoDao;
import com.test.model.PersonInfo;
import com.test.service.PersonInfoService;
import com.test.vo.Page;
import com.test.vo.searcher.PersonInfoManagePageSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XinLian on 2016/3/30.
 */
@Service("personInfoService")
public class PersonInfoServiceImpl extends GenericServiceImpl<PersonInfo,Long> implements PersonInfoService {

    @Autowired
    PersonInfoDao personInfoDao;

    @Override
    public int insertPersonInfo(PersonInfo personInfo) {
        return personInfoDao.insert(personInfo);
    }

    @Override
    public int updatePersonInfo(PersonInfo personInfo) {
        return personInfoDao.update(personInfo);
    }

    @Override
    public List<PersonInfo> getPersonInfoByUsername(String username) {
        return personInfoDao.getPersonInfoByUsername(username);
    }

    @Override
    public PersonInfo getPersonInfoByToken(String token) {
        return personInfoDao.getPersonInfoByToken(token);
    }

    @Override
    public Page<PersonInfo> searchPersonInfo(PersonInfoManagePageSearcher personInfoManagePageSearcher) {

        personInfoManagePageSearcher.setPageSize(10);
        personInfoManagePageSearcher.setResult(personInfoDao.searchPage(personInfoManagePageSearcher));
        return personInfoManagePageSearcher;
    }
}
