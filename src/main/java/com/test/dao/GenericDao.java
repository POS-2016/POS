package com.test.dao;

import com.test.vo.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by XinLian on 2016/3/9.
 */
public interface GenericDao <T, PK extends Serializable> {

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
    T getNoDeletedObj(final PK id);

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    T get(final Long id);

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 查询数据列表
     *
     * @param page
     * @return
     */
    List<T> searchPage(Page<T> page);
}
