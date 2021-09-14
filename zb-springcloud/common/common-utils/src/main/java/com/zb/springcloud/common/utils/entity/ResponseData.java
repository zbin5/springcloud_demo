package com.zb.springcloud.common.utils.entity;

import lombok.Data;

@Data
public class ResponseData {
    private Object data;
    private Integer code;
    private String msg;

    public ResponseData(){
    }

    public ResponseData(Object data,Integer code,String msg){
        this.code=code;
        this.data=data;
        this.msg=msg;
    }

    public ResponseData(String msg){
        this.code=9999;
        this.data=null;
        this.msg=msg;
    }
}
