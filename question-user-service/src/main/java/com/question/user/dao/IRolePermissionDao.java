package com.question.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.question.user.entity.RolePermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Date 2021/4/7 9:10
 * @Created by liukaihua
 */

@Mapper
@Repository
public interface IRolePermissionDao extends BaseMapper<RolePermissionEntity> {

}
