package com.question.user.dto;

import com.question.common.entity.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Date 2021/4/7 23:06
 * @Created by liukaihua
 */

@Data
public class QueryRoleDTO extends BaseRequest {

    private static final long serialVersionUID = -189441472080908458L;

    //用户id
    @NotNull(message = "用户id不能为空")
    private Long userId;

}
