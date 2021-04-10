package com.question.user.dto;

import com.question.common.entity.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Date 2021/4/7 23:21
 * @Created by liukaihua
 */

@Data
public class QueryPermissionDTO extends BaseRequest {

    private static final long serialVersionUID = 7878360631033215585L;

    //角色id
    @NotNull(message = "角色id不能为空")
    private List<Long> roleIds;

}
