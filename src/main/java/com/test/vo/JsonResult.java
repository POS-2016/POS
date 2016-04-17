package com.test.vo;

/**
 * Created by XinLian on 2016/4/15.
 */
public class JsonResult {
    private boolean success;
    private String  info;
    private Object  data;

    public JsonResult(){
        this(true, null, null);
    }

    public JsonResult(boolean success){
        this(success, null, null);
    }

    public JsonResult(boolean success, String info){
        this(success, info, null);
    }

    public JsonResult(boolean success, String info, Object data){
        this.success = success;
        this.info = info;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
