package com.dingdangmaoup.mini.platform.domain.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @TableName mini_registered_client
 */
@TableName(value ="mini_registered_client")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MiniRegisteredClient extends BaseEntity {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * 
     */
    @TableField(value = "client_id")
    private String clientId;

    /**
     * 
     */
    @TableField(value = "client_id_issued_at")
    private Instant clientIdIssuedAt;

    /**
     * 
     */
    @TableField(value = "client_secret")
    private String clientSecret;

    /**
     * 
     */
    @TableField(value = "client_secret_expires_at")
    private Instant clientSecretExpiresAt;

    /**
     * 
     */
    @TableField(value = "client_name")
    private String clientName;

    /**
     * 
     */
    @TableField(value = "client_authentication_methods")
    private String clientAuthenticationMethods;

    /**
     * 
     */
    @TableField(value = "authorization_grant_types")
    private String authorizationGrantTypes;

    /**
     * 
     */
    @TableField(value = "redirect_uris")
    private String redirectUris;

    /**
     * 
     */
    @TableField(value = "post_logout_redirect_uris")
    private String postLogoutRedirectUris;

    /**
     * 
     */
    @TableField(value = "scopes")
    private String scopes;

    /**
     * 
     */
    @TableField(value = "client_settings")
    private String clientSettings;

    /**
     * 
     */
    @TableField(value = "token_settings")
    private String tokenSettings;




}