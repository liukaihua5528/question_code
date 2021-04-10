package com.question.user.feign;

import com.question.common.entity.BaseResponse;
import com.question.user.dto.QueryPermissionDTO;
import com.question.user.dto.QueryRoleDTO;
import com.question.user.dto.QueryUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Date 2021/4/1 23:48
 * @Created by liukaihua
 */

@FeignClient(name = "question-user-service")
public interface UserFeignClient {

    /**
     * 根据账户查询用户信息
     * @param dto
     * @return
     */
    @PostMapping("queryUserByAccount")
    BaseResponse queryUserByAccount(@RequestBody QueryUserDTO dto);

    /**
     * 根据用户id查询角色信息
     * @param dto
     * @return
     */
    @PostMapping("selectRoleByUserId")
    BaseResponse selectRoleByUserId(@RequestBody QueryRoleDTO dto);

    /**
     * 根据角色id查询权限
     * @param dto
     * @return
     */
    @PostMapping("queryPermissionByRoleId")
    BaseResponse queryPermissionByRoleId(@RequestBody QueryPermissionDTO dto);

}
