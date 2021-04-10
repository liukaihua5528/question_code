package com.question.user.servcice;

import com.question.common.entity.BaseOutput;

import java.util.List;

/**
 * @Date 2021/4/7 22:33
 * @Created by liukaihua
 */
public interface IUserService {

    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
    BaseOutput queryUserByAccount(String account);

    /**
     * 根据角色id查询权限
     * @param roleIds
     * @return
     */
    BaseOutput queryPermissionByRoleId(List<Long> roleIds);

    /**
     * 根据用户id查询角色信息
     * @param userId
     * @return
     */
    BaseOutput selectRoleByUserId(Long userId);

}
