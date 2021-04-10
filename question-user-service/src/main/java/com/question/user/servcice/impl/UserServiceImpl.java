package com.question.user.servcice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.question.common.entity.BaseOutput;
import com.question.common.enums.ResponseCode;
import com.question.common.utils.BaseOutputUtil;
import com.question.user.dao.IPermissionDao;
import com.question.user.dao.IRoleDao;
import com.question.user.dao.IUserDao;
import com.question.user.entity.RoleEntity;
import com.question.user.entity.UserEntity;
import com.question.user.servcice.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date 2021/4/7 22:36
 * @Created by liukaihua
 */

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IPermissionDao permissionDao;

    @Autowired
    private IRoleDao roleDao;

    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
    public BaseOutput queryUserByAccount(String account) {
        log.info("根据账户查询用户信息-开始 请求参数:account:{}",account);
        BaseOutput output = new BaseOutput();
        try {
            UserEntity entity = userDao.selectOne(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getAccount, account).last(" LIMIT 1"));
            output.setData(entity);
            BaseOutputUtil.setOutput(output, ResponseCode.TK00001.getCode(),ResponseCode.TK00001.getMessage());
        }catch (Exception e){
            log.error("根据账户查询用户信息-异常 throw error:{}",e);
            BaseOutputUtil.setOutput(output, ResponseCode.TK00002.getCode(),ResponseCode.TK00002.getMessage());
        }finally {
            log.info("根据账户查询用户信息-结束 返回参数:output:{}",output);
        }
        return output;
    }

    /**
     * 根据角色id查询权限
     * @param roleIds
     * @return
     */
    public BaseOutput queryPermissionByRoleId(List<Long> roleIds) {
        log.info("根据角色id查询权限-开始 请求参数:roleIds:{}",roleIds);
        BaseOutput output = new BaseOutput();
        try {
            List<String> list = permissionDao.queryPermissionByRoleId(roleIds);
            output.setData(list);
            BaseOutputUtil.setOutput(output, ResponseCode.TK00001.getCode(),ResponseCode.TK00001.getMessage());
        }catch (Exception e){
            log.error("根据角色id查询权限-异常 throw error:{}",e);
            BaseOutputUtil.setOutput(output, ResponseCode.TK00002.getCode(),ResponseCode.TK00002.getMessage());
        }finally {
            log.info("根据角色id查询权限-结束 返回参数:output:{}",output);
        }
        return output;
    }

    /**
     * 根据用户id查询角色信息
     * @param userId
     * @return
     */
    public BaseOutput selectRoleByUserId(Long userId) {
        log.info("根据用户id查询角色信息-开始 请求参数:userId:{}",userId);
        BaseOutput output = new BaseOutput();
        try {
            List<RoleEntity> list = roleDao.selectRoleByUserId(userId);
            output.setData(list);
            BaseOutputUtil.setOutput(output, ResponseCode.TK00001.getCode(),ResponseCode.TK00001.getMessage());
        }catch (Exception e){
            log.error("根据角色id查询权限-异常 throw error:{}",e);
            BaseOutputUtil.setOutput(output, ResponseCode.TK00002.getCode(),ResponseCode.TK00002.getMessage());
        }finally {
            log.info("根据角色id查询权限-结束 返回参数:output:{}",output);
        }
        return output;
    }
}
