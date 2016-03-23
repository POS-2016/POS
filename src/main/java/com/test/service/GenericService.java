package com.test.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by XinLian on 2016/3/9.
 */
public interface GenericService<T, PK extends Serializable> {

    /**
     * 查询所有对象
     *
     * @return
     */
    List<T> listAll();


    /**
     * 得到合法的非逻辑删除对象。
     *
     * @param id
     * @return
     */
    T getNoDeletedObj(PK id);

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    T get(final Long id);



}
