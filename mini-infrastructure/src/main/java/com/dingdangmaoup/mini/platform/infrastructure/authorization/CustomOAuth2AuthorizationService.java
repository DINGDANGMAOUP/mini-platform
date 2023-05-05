package com.dingdangmaoup.mini.platform.infrastructure.authorization;

import com.dingdangmaoup.mini.platform.domain.model.MiniAuthorization;
import com.dingdangmaoup.mini.platform.infrastructure.mapstruct.MiniAuthorizationConverter;
import com.dingdangmaoup.mini.platform.infrastructure.service.MiniAuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.core.oidc.endpoint.OidcParameterNames;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class CustomOAuth2AuthorizationService implements OAuth2AuthorizationService {
    private final MiniAuthorizationService miniAuthorizationService;
    private final RegisteredClientRepository registeredClientRepository;
    private final MiniAuthorizationConverter authorizationConverter;

    @Override
    public void save(OAuth2Authorization authorization) {
        Assert.notNull(authorization, "authorization cannot be null");
        MiniAuthorization miniAuthorization = authorizationConverter.toMiniAuthorization(authorization);
        miniAuthorizationService.save(miniAuthorization);
    }

    @Override
    public void remove(OAuth2Authorization authorization) {
        Assert.notNull(authorization, "authorization cannot be null");
        miniAuthorizationService.removeById(authorization.getId());
    }

    @Override
    public OAuth2Authorization findById(String id) {
        Assert.hasText(id, "id cannot be empty");
        MiniAuthorization authorization = miniAuthorizationService.getById(id);
        RegisteredClient registeredClient = registeredClientRepository.findById(authorization.getRegisteredClientId());
        if (registeredClient == null) {
            throw new DataRetrievalFailureException(
                    "The RegisteredClient with id '" + authorization.getRegisteredClientId() + "' was not found in the RegisteredClientRepository.");
        }
        return authorizationConverter.mergeToOAuth2Authorization(authorization, registeredClient);
    }

    @Override
    public OAuth2Authorization findByToken(String token, OAuth2TokenType tokenType) {
        Assert.hasText(token, "token cannot be empty");
        Optional<MiniAuthorization> result;
        if (tokenType == null) {
            result = miniAuthorizationService.findByStateOrAuthorizationCodeValueOrAccessTokenValueOrRefreshTokenValue(token);
        } else if (OAuth2ParameterNames.STATE.equals(tokenType.getValue())) {
            result = miniAuthorizationService.findByState(token);
        } else if (OAuth2ParameterNames.CODE.equals(tokenType.getValue())) {
            result = miniAuthorizationService.findByAuthorizationCodeValue(token);
        } else if (OAuth2ParameterNames.ACCESS_TOKEN.equals(tokenType.getValue())) {
            result = miniAuthorizationService.findByAccessTokenValue(token);
        } else if (OAuth2ParameterNames.REFRESH_TOKEN.equals(tokenType.getValue())) {
            result = miniAuthorizationService.findByRefreshTokenValue(token);
        } else if (OidcParameterNames.ID_TOKEN.equals(tokenType.getValue())) {
            result = miniAuthorizationService.findByOidcIdTokenValue(token);
        } else {
            result = Optional.empty();
        }
        return result.map(authorization -> {
            RegisteredClient registeredClient = this.registeredClientRepository.findById(authorization.getRegisteredClientId());
            if (registeredClient == null) {
                throw new DataRetrievalFailureException(
                        "The RegisteredClient with id '" + result.get().getRegisteredClientId() + "' was not found in the RegisteredClientRepository.");
            }
            return authorizationConverter.mergeToOAuth2Authorization(authorization, registeredClient);
        }).orElse(null);
    }
}
