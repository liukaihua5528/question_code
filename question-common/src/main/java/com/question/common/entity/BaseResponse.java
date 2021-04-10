package com.question.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Date 2021/4/1 23:05
 * @Created by liukaihua
 */

@Data
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -6032707572115997304L;

    private String resultCode;

    private String message;

    private Object data;

    private boolean isSuccess;
}
