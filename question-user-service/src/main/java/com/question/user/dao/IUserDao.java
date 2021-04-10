package com.question.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.question.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Date 2021/4/7 0:19
 * @Created by liukaihua
 */

@Mapper
@Repository
public interface IUserDao extends BaseMapper<UserEntity> {

}
