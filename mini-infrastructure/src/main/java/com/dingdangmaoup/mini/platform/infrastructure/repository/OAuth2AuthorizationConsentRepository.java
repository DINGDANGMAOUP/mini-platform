package com.dingdangmaoup.mini.platform.infrastructure.repository;

import com.dingdangmaoup.mini.platform.domain.model.MiniAuthorizationConsent;
import com.dingdangmaoup.mini.platform.infrastructure.mapstruct.MiniAuthorizationConsentConverter;
import com.dingdangmaoup.mini.platform.infrastructure.service.MiniAuthorizationConsentService;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.util.Assert;

@AllArgsConstructor
public class OAuth2AuthorizationConsentRepository implements OAuth2AuthorizationConsentService {
    private final MiniAuthorizationConsentService miniAuthorizationConsentService;
    private final MiniAuthorizationConsentConverter miniAuthorizationConsentConverter;

    @Override
    public void save(OAuth2AuthorizationConsent authorizationConsent) {
        Assert.notNull(authorizationConsent, "authorizationConsent cannot be null");
        MiniAuthorizationConsent miniAuthorizationConsent = miniAuthorizationConsentConverter.toMiniAuthorizationConsent(authorizationConsent);
        miniAuthorizationConsentService.save(miniAuthorizationConsent);
    }

    @Override
    public void remove(OAuth2AuthorizationConsent authorizationConsent) {
        Assert.notNull(authorizationConsent, "authorizationConsent cannot be null");
        // 根据注册的客户端id和用户id删除
        miniAuthorizationConsentService.removeByClientIdAndPrincipalName(authorizationConsent.getRegisteredClientId(), authorizationConsent.getPrincipalName());
    }

    @Override
    public OAuth2AuthorizationConsent findById(String registeredClientId, String principalName) {
        Assert.hasText(registeredClientId, "registeredClientId cannot be empty");
        Assert.hasText(principalName, "principalName cannot be empty");
        MiniAuthorizationConsent miniAuthorizationConsent = miniAuthorizationConsentService.getByRegisteredClientIdAndPrincipalName(registeredClientId, principalName);
        return miniAuthorizationConsentConverter.toOAuth2AuthorizationConsent(miniAuthorizationConsent);
    }
}
