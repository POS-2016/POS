package com.test.vo.searcher;

import com.test.model.ParkingSpace;
import com.test.model.Reserve;
import com.test.vo.Page;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by XinLian on 2016/3/14.
 */
public class ReserveManagePageSearcher extends Page<Reserve> {

    public ReserveManagePageSearcher() {
        super();
    }

    private String date;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private Long startTimeStamp;
    private Long endTimeStamp;

    public String getDate() {
        if(this.startTime == null || this.startTime.equals(""))
            return date;
        else
            return this.startTime + "~" + this.endTime;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public Long getStartTimeStamp() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.startTimeStamp = format.parse(startTime).getTime();
        return startTimeStamp;
    }

    public void setStartTimeStamp(Long startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public Long getEndTimeStamp() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.endTimeStamp = format.parse(endTime).getTime();
        return endTimeStamp;
    }

    public void setEndTimeStamp(Long endTiemStamp) {
        this.endTimeStamp = endTiemStamp;
    }
}