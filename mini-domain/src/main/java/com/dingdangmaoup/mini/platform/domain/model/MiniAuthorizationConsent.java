package com.dingdangmaoup.mini.platform.domain.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @TableName mini_authorization_consent
 */
@TableName(value ="mini_authorization_consent")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MiniAuthorizationConsent extends BaseEntity  {
    /**
     * 
     */
    @TableId(value = "registered_client_id")
    private String registeredClientId;

    /**
     * 
     */
    @TableId(value = "principal_name")
    private String principalName;

    /**
     * 
     */
    @TableField(value = "authorities")
    private String authorities;




}