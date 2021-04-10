package com.question.user.dto;

import com.question.common.entity.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Date 2021/4/8 0:41
 * @Created by liukaihua
 */

@Data
public class UserLoginDTO extends BaseRequest {

    private static final long serialVersionUID = -3266321748080771321L;

    //密码
    @NotNull(message = "密码不能为空")
    private String password;

    //用户名
    @NotNull(message = "用户名不能为空")
    private String userName;


}
