package com.dingdangmaoup.mini.platform.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.*;



@TableName("mini_user")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
  /**
   * 用户id
   */
  @TableId(value = "user_id", type = IdType.ASSIGN_ID)
  private Long userId;
  /**
   * 用户名
   */
  @TableField(value = "username")
  private String username;
  /**
   * 密码
   */
  @TableField(value = "password")
  private String password;
  /**
   * 电话
   */
  @TableField(value = "phone")
  private String phone;
  /**
   * 电子邮件
   */
  @TableField(value = "email")
  private String email;
  /**
   * 盐
   */
  @TableField(value = "salt")
  private String salt;

}
