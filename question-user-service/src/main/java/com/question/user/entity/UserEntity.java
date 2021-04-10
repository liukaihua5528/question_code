package com.question.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.question.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Date 2021/4/2 0:14
 * @Created by liukaihua
 */

@Data
@TableName(value = "user")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -3761543653767772897L;

    //id
    @TableId(value = "ID",type = IdType.ID_WORKER)
    private Long id;

   //密码
    @TableField(value = "PASSWORD")
    private String password;

    //用户名
    @TableField(value = "USER_NAME")
    private String userName;

    //账户
    @TableField(value = "ACCOUNT")
    private String account;

}
