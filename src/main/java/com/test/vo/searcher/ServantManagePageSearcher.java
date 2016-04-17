package com.test.vo.searcher;

import com.test.model.Servant;
import com.test.vo.Page;

/**
 * Created by XinLian on 2016/4/17.
 */
public class ServantManagePageSearcher extends Page<Servant> {

    public ServantManagePageSearcher() {
        super();
    }

    private Integer id;
    private String username;
    private Integer status;
    private Integer authority;

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
