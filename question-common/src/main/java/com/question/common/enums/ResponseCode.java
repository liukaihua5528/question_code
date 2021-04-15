package com.question.common.enums;


/**
 * @Date 2021/4/1 23:02
 * @Created by liukaihua
 */

public enum ResponseCode {

    TK00001("TK00001","成功"),

    TK00002("TK00002","失败"),

    TK00003("TK00003","参数为空"),

    TK00004("TK00004","系统异常"),

    TK10001("TK10001","账户不存在"),

    TK10002("TK10002","账号被禁用"),

    TK10003("TK10003","用户名或密码错误"),

    TK10004("TK10004","账号未登录"),

    TK10005("TK10005","用户重复登陆"),

    TK10006("TK10006","用户名或密码为空"),
    ;

    private String code;

    private String message;

    ResponseCode() {
    }

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
