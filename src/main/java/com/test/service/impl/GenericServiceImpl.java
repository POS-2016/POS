package com.test.service.impl;

import com.test.dao.GenericDao;
import com.test.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by XinLian on 2016/3/9.
 */
public class GenericServiceImpl <T, PK extends Serializable> implements GenericService<T, PK> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected GenericDao<T, PK> dao;

    public GenericServiceImpl(){

    }

    public GenericServiceImpl(GenericDao<T, PK> genericDao) {
        this.dao = genericDao;
    }

    @Override
    public List<T> listAll() {
        return dao.listAll();
    }

    @Override
    public T getNoDeletedObj(PK id) {
        return dao.getNoDeletedObj(id);
    }

    @Override
    public T get(Long id) {
        return dao.get(id);
    }

}
