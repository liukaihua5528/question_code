package com.question.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.question.user.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Date 2021/4/7 0:23
 * @Created by liukaihua
 */

@Mapper
@Repository
public interface IRoleDao extends BaseMapper<RoleEntity> {

    //根据用户id查询角色信息
    List<RoleEntity> selectRoleByUserId(Long userId);

}
