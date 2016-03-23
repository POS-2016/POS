package com.test.vo.searcher;

import com.test.model.ParkingSpace;
import com.test.vo.Page;

import java.util.Date;

/**
 * Created by XinLian on 2016/3/14.
 */
public class ParkingSpaceManagePageSearcher extends Page<ParkingSpace> {

    public ParkingSpaceManagePageSearcher() {
        super();
    }

    public ParkingSpaceManagePageSearcher(String status,double cost) {
        super();
        this.status = status;
        this.cost = cost;
    }

    private String status;
    private Double cost;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
