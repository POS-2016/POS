package com.test.vo.searcher;

import com.test.model.PersonInfo;
import com.test.vo.Page;

/**
 * Created by XinLian on 2016/3/30.
 */
public class PersonInfoManagePageSearcher extends Page<PersonInfo> {

    public PersonInfoManagePageSearcher() { super();}

    public PersonInfoManagePageSearcher(String username) {

        this.username = username;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
