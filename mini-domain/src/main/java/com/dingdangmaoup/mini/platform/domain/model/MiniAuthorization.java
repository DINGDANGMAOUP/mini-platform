package com.dingdangmaoup.mini.platform.domain.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @TableName mini_authorization
 */
@TableName(value = "mini_authorization")
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MiniAuthorization extends BaseEntity {
    /**
     *
     */
    @TableId(value = "id")
    private String id;

    /**
     *
     */
    @TableField(value = "registered_client_id")
    private String registeredClientId;

    /**
     *
     */
    @TableField(value = "principal_name")
    private String principalName;

    /**
     *
     */
    @TableField(value = "authorization_grant_type")
    private String authorizationGrantType;

    /**
     *
     */
    @TableField(value = "authorized_scopes")
    private String authorizedScopes;

    /**
     *
     */
    @TableField(value = "state")
    private String state;

    /**
     *
     */
    @TableField(value = "authorization_code_issued_at")
    private LocalDateTime authorizationCodeIssuedAt;

    /**
     *
     */
    @TableField(value = "authorization_code_expires_at")
    private LocalDateTime authorizationCodeExpiresAt;

    /**
     *
     */
    @TableField(value = "access_token_issued_at")
    private LocalDateTime accessTokenIssuedAt;

    /**
     *
     */
    @TableField(value = "access_token_expires_at")
    private LocalDateTime accessTokenExpiresAt;

    /**
     *
     */
    @TableField(value = "access_token_type")
    private String accessTokenType;

    /**
     *
     */
    @TableField(value = "access_token_scopes")
    private String accessTokenScopes;

    /**
     *
     */
    @TableField(value = "oidc_id_token_issued_at")
    private LocalDateTime oidcIdTokenIssuedAt;

    /**
     *
     */
    @TableField(value = "oidc_id_token_expires_at")
    private LocalDateTime oidcIdTokenExpiresAt;

    /**
     *
     */
    @TableField(value = "refresh_token_issued_at")
    private LocalDateTime refreshTokenIssuedAt;

    /**
     *
     */
    @TableField(value = "refresh_token_expires_at")
    private LocalDateTime refreshTokenExpiresAt;

    /**
     *
     */
    @TableField(value = "user_code_issued_at")
    private LocalDateTime userCodeIssuedAt;

    /**
     *
     */
    @TableField(value = "user_code_expires_at")
    private LocalDateTime userCodeExpiresAt;

    /**
     *
     */
    @TableField(value = "device_code_issued_at")
    private LocalDateTime deviceCodeIssuedAt;

    /**
     *
     */
    @TableField(value = "device_code_expires_at")
    private LocalDateTime deviceCodeExpiresAt;

    /**
     *
     */
    @TableField(value = "attributes")
    private byte[] attributes;

    /**
     *
     */
    @TableField(value = "authorization_code_value")
    private byte[] authorizationCodeValue;

    /**
     *
     */
    @TableField(value = "authorization_code_metadata")
    private byte[] authorizationCodeMetadata;

    /**
     *
     */
    @TableField(value = "access_token_value")
    private byte[] accessTokenValue;

    /**
     *
     */
    @TableField(value = "access_token_metadata")
    private byte[] accessTokenMetadata;

    /**
     *
     */
    @TableField(value = "oidc_id_token_value")
    private byte[] oidcIdTokenValue;

    /**
     *
     */
    @TableField(value = "oidc_id_token_metadata")
    private byte[] oidcIdTokenMetadata;

    /**
     *
     */
    @TableField(value = "refresh_token_value")
    private byte[] refreshTokenValue;

    /**
     *
     */
    @TableField(value = "refresh_token_metadata")
    private byte[] refreshTokenMetadata;

    /**
     *
     */
    @TableField(value = "user_code_value")
    private byte[] userCodeValue;

    /**
     *
     */
    @TableField(value = "user_code_metadata")
    private byte[] userCodeMetadata;

    /**
     *
     */
    @TableField(value = "device_code_value")
    private byte[] deviceCodeValue;

    /**
     *
     */
    @TableField(value = "device_code_metadata")
    private byte[] deviceCodeMetadata;


}