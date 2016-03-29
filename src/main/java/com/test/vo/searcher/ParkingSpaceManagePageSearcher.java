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
    private String startTime;
    private String endTime;
    private String date;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDate() {
        if(this.startTime == null || this.startTime.equals(""))
            return date;
        else
            return this.startTime + "~" + this.endTime;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
