package com.panglin.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/6 11:30
 */
public class Msg {
    private int code;
    private String msg;
    private Map<String,Object> extend = new HashMap<>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public static Msg success(){
        Msg msg=new Msg();
        msg.setCode(100);
        msg.setMsg("操作成功");
        return msg;
    }

    public static Msg success(String s){
        Msg msg=new Msg();
        msg.setCode(100);
        msg.setMsg(s);
        return msg;
    }




    public static Msg fail(){
        Msg msg=new Msg();
        msg.setCode(200);
        msg.setMsg("操作失败");
        return msg;
    }
    public static Msg fail(String msgs){
        Msg msg=new Msg();
        msg.setCode(200);
        msg.setMsg(msgs);
        return msg;
    }

    public Msg add(String name,Object obj){
        this.getExtend().put(name,obj);
        return this;
    }
}
