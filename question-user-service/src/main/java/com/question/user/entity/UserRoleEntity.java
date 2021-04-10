package com.question.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.question.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Date 2021/4/7 9:13
 * @Created by liukaihua
 */

@Data
@TableName(value = "user_role")
public class UserRoleEntity extends BaseEntity {

    private static final long serialVersionUID = 4183706018717519223L;

    //id
    @TableId(value = "ID",type = IdType.ID_WORKER)
    private Long id;

    //用户id
    @TableField(value = "USER_ID")
    private Long userId;

    //角色id
    @TableField(value = "ROLE_ID")
    private Long roleId;

}
