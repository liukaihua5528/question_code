package com.question.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.question.user.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Date 2021/4/7 9:14
 * @Created by liukaihua
 */

@Mapper
@Repository
public interface IUserRoleDao extends BaseMapper<UserRoleEntity> {

}
