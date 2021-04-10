package com.question.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.question.user.entity.PermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Date 2021/4/7 8:53
 * @Created by liukaihua
 */

@Mapper
@Repository
public interface IPermissionDao extends BaseMapper<PermissionEntity> {

    //根据角色id查询权限
    List<String> queryPermissionByRoleId(@Param("roleIds")  List<Long> roleIds);

}
