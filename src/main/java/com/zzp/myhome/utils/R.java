package com.zzp.myhome.utils;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :  ZHANGZP
 * @Description :
 * @Creation Date:  2019/3/5
 */
public class R extends HashMap<String, Object> {

        private static final long serialVersionUID = 1L;

        public R() {
            this.put((String)"code", 0);
            this.put((String)"msg", "success");
        }

        public static R error() {
            return error(500, "未知异常，请联系管理员");
        }

        public static R error(String msg) {
            return error(500, msg);
        }

        public static R error(int code, String msg) {
            R r = new R();
            r.put((String)"code", code);
            r.put((String)"msg", msg);
            return r;
        }

        public static R ok(String msg) {
            R r = new R();
            r.put((String)"msg", msg);
            return r;
        }

        public static R data(Object obj) {
            R r = new R();
            r.put("data", obj);
            return r;
        }

        public static R ok(Map<String, Object> map) {
            R r = new R();
            r.putAll(map);
            return r;
        }

        public boolean isErr() {
            int code = (Integer)this.get("code");
            return code != 0;
        }

        public int getCode() {
            return (Integer)this.get("code");
        }

        public String getMsg() {
            return (String)this.get("msg");
        }

        public static R ok() {
            return new R();
        }

        public R put(String key, Object value) {
            super.put(key, value);
            return this;
        }

        public <T> T getData(Class<T> clazz) {
            Object data = this.get("data");
            if (data != null) {
                String s = JSON.toJSONString(data);
                return JSON.parseObject(s, clazz);
            } else if (this.isErr()) {
                ZRException zrException = new ZRException(this.getMsg());
                zrException.setCode(this.getCode());
                throw zrException;
            } else {
                throw new ZRException("返回内容为空");
            }
        }

        public <T> List<T> getDataList(Class<T> clazz) {
            Object data = this.get("data");
            if (data != null) {
                String s = JSON.toJSONString(data);
                return JSON.parseArray(s, clazz);
            } else if (this.isErr()) {
                ZRException zrException = new ZRException(this.getMsg());
                zrException.setCode(this.getCode());
                throw zrException;
            } else {
                throw new ZRException("返回内容为空");
            }
        }

        private class ParameterizedTypeImpl implements ParameterizedType {
            Class clazz;

            public ParameterizedTypeImpl(Class clz) {
                this.clazz = clz;
            }

            public Type[] getActualTypeArguments() {
                return new Type[]{this.clazz};
            }

            public Type getRawType() {
                return List.class;
            }

            public Type getOwnerType() {
                return null;
            }
        }

}
