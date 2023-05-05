package com.dingdangmaoup.mini.platform.infrastructure.mapstruct;

import com.dingdangmaoup.mini.platform.domain.model.MiniAuthorizationConsent;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;
import org.springframework.util.StringUtils;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {StringUtils.class, GrantedAuthority.class, Collectors.class})
public interface MiniAuthorizationConsentConverter {
    /**
     * 将【OAuth2AuthorizationConsent】的对象转换为【mini_authorization_consent】的DO对象
     *
     * @param oAuth2AuthorizationConsent o auth2授权同意
     * @return {@link MiniAuthorizationConsent}
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "isDelete", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "updateBy", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "createBy", ignore = true)
    @Mapping(target = "authorities", expression = "java(StringUtils.collectionToCommaDelimitedString(oAuth2AuthorizationConsent.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet())))")
    MiniAuthorizationConsent toMiniAuthorizationConsent(OAuth2AuthorizationConsent oAuth2AuthorizationConsent);

    /**
     * 将【mini_authorization_consent】的DO对象转换为【OAuth2AuthorizationConsent】的对象
     *
     * @param miniAuthorizationConsent 迷你授权同意
     * @return {@link OAuth2AuthorizationConsent}
     */
    default OAuth2AuthorizationConsent toOAuth2AuthorizationConsent(MiniAuthorizationConsent miniAuthorizationConsent) {
        var builder = OAuth2AuthorizationConsent.withId(miniAuthorizationConsent.getRegisteredClientId(), miniAuthorizationConsent.getPrincipalName());
        StringUtils.commaDelimitedListToSet(miniAuthorizationConsent.getAuthorities()).forEach(authority -> builder.authority(new SimpleGrantedAuthority(authority)));
        return builder.build();
    }

}
