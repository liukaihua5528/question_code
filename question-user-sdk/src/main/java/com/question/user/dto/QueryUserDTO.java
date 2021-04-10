package com.question.user.dto;

import com.question.common.entity.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Date 2021/4/7 22:52
 * @Created by liukaihua
 */

@Data
public class QueryUserDTO extends BaseRequest {

    private static final long serialVersionUID = 5935191121808286530L;

    //账户
    @NotNull(message = "账户信息不能为空")
    private String account;

}
