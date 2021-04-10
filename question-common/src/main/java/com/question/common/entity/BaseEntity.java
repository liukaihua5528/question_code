package com.question.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Date 2021/4/1 23:04
 * @Created by liukaihua
 */

@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2810692832658763901L;

    //创建人id
    private Long createId;
    //创建时间
    private String createTime;
    //更新人id
    private Long updateId;
    //更新时间
    private String updateTime;
}
