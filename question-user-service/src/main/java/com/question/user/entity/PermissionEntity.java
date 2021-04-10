package com.question.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.question.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Date 2021/4/7 8:51
 * @Created by liukaihua
 */

@Data
@TableName(value = "permission")
public class PermissionEntity extends BaseEntity {

    private static final long serialVersionUID = 7019792281420220308L;

    //id
    @TableId(value = "ID",type = IdType.ID_WORKER)
    private Long id;

    //权限名称
    @TableField(value = "PERMISSION")
    private String permission;

    //权限描述
    @TableField(value = "DESC")
    private String desc;


}
