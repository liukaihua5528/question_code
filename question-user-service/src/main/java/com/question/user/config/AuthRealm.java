package com.question.user.config;

import com.question.common.entity.BaseOutput;
import com.question.user.entity.RoleEntity;
import com.question.user.entity.UserEntity;
import com.question.user.servcice.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Date 2021/4/8 0:15
 * @Created by liukaihua
 */

@Slf4j
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserEntity userEntity = (UserEntity) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //根据用户id查询角色信息
        BaseOutput output = userService.selectRoleByUserId(userEntity.getId());
        List<RoleEntity> roleList = (List<RoleEntity>) output.getData();
        Set<String> roleSet = new HashSet<>();
        List<Long> roleIds = new ArrayList<>();
        for (RoleEntity role:roleList){
            roleSet.add(role.getRole());
            roleIds.add(role.getId());
        }
        //放入角色信息
        authorizationInfo.setRoles(roleSet);
        //放入权限信息
        List<String> permissionList = (List<String>) userService.queryPermissionByRoleId(roleIds).getData();
        authorizationInfo.setStringPermissions(new HashSet<>(permissionList));
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //根据用户名查询用户信息
        UserEntity userEntity = (UserEntity) userService.queryUserByAccount(token.getUsername()).getData();
        if (userEntity == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(userEntity,userEntity.getPassword(),getName());
    }
}
