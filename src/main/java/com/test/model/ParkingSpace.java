package com.test.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XinLian on 2016/3/13.
 */
public class ParkingSpace implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Long ppName;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPpName() {
        return ppName;
    }

    public void setPpName(Long ppName) {
        this.ppName = ppName;
    }
}
