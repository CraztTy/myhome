package com.zzp.myhome.utils;

/**
 * @author :  ZHANGZP
 * @Description :
 * @Creation Date:  2019/3/5
 */
public class ZRException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String msg;
    private int code = 500;

    public ZRException(BaseConstant baseConstant) {
        super(baseConstant.getMsg());
        this.msg = baseConstant.getMsg();
        this.code = baseConstant.getCode();
    }

    public ZRException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ZRException(BaseConstant baseConstant, Throwable e) {
        super(baseConstant.getMsg(), e);
        this.msg = baseConstant.getMsg();
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
