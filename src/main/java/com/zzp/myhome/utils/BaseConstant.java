package com.zzp.myhome.utils;

/**
 * @author :  ZHANGZP
 * @Description :
 * @Creation Date:  2019/3/5
 */
public interface BaseConstant {

    int getCode();

    String getMsg();

    public static enum CommonConstant implements BaseConstant {
        REDIS_ERROR(510, "Redis错误"),
        TOKEN_GEN_ERROR(511, "Token生成失败");

        private String msg;
        private int code;

        private CommonConstant(int i, String s) {
            this.code = i;
            this.msg = s;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
