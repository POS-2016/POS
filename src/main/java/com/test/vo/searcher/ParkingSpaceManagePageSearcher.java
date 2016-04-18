package com.test.vo.searcher;

import com.test.model.ParkingSpace;
import com.test.vo.Page;

import java.util.*;

/**
 * Created by XinLian on 2016/3/14.
 */
public class ParkingSpaceManagePageSearcher extends Page<ParkingSpace> {

    public ParkingSpaceManagePageSearcher() {
        super();
    }

    public ParkingSpaceManagePageSearcher(Long id,String status,int isEnable) {
        super();
        this.id = id;
        this.status = status;
        this.isEnable = isEnable;
    }

    private Long id;
    private String status;
    private int isEnable;
    private Long ppName;

    public Long getPpName() {
        return ppName;
    }

    public void setPpName(Long ppName) {
        this.ppName = ppName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
