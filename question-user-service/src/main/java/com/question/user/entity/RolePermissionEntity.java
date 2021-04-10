package com.question.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.question.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Date 2021/4/7 9:06
 * @Created by liukaihua
 */

@Data
@TableName(value = "role_permission")
public class RolePermissionEntity extends BaseEntity {

    private static final long serialVersionUID = -6831189635545319335L;

    //id
    @TableId(value = "ID",type = IdType.ID_WORKER)
    private Long id;

    //角色id
    @TableField(value = "ROLE_ID")
    private Long roleId;

    //权限id
    @TableField(value = "PERMISSION_ID")
    private Long permissionId;

}
