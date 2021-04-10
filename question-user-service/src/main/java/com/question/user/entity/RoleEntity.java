package com.question.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.question.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Date 2021/4/7 0:22
 * @Created by liukaihua
 */

@Data
@TableName(value = "role")
public class RoleEntity extends BaseEntity {

    private static final long serialVersionUID = -8030590392810279317L;

    //id
    @TableId(value = "ID",type = IdType.ID_WORKER)
    private Long id;

    //角色
    @TableField(value = "ROLE")
    private String role;

    //描述
    @TableField(value = "DESC")
    private String desc;

}
