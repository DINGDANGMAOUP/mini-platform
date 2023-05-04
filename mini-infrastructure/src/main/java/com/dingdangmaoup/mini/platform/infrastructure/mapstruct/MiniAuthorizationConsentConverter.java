package com.dingdangmaoup.mini.platform.infrastructure.mapstruct;

import com.dingdangmaoup.mini.platform.domain.model.MiniAuthorizationConsent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;

@Mapper(componentModel = "spring")
public interface MiniAuthorizationConsentConverter {
    /**
     * 将【OAuth2AuthorizationConsent】的对象转换为【mini_authorization_consent】的DO对象
     *
     * @param oAuth2AuthorizationConsent o auth2授权同意
     * @return {@link MiniAuthorizationConsent}
     */
    @Mapping(target = "isDelete", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "updateBy", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "createBy", ignore = true)
    MiniAuthorizationConsent toMiniAuthorizationConsent(OAuth2AuthorizationConsent oAuth2AuthorizationConsent);

    /**
     * 将【mini_authorization_consent】的DO对象转换为【OAuth2AuthorizationConsent】的对象
     *
     * @param miniAuthorizationConsent 迷你授权同意
     * @return {@link OAuth2AuthorizationConsent}
     */
    OAuth2AuthorizationConsent toOAuth2AuthorizationConsent(MiniAuthorizationConsent miniAuthorizationConsent);

}
