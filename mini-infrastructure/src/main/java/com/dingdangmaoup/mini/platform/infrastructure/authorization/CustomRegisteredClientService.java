package com.dingdangmaoup.mini.platform.infrastructure.authorization;

import com.dingdangmaoup.mini.platform.infrastructure.mapstruct.MiniRegisteredClientConverter;
import com.dingdangmaoup.mini.platform.infrastructure.service.MiniRegisteredClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class CustomRegisteredClientService implements RegisteredClientRepository {
    private final MiniRegisteredClientService registeredClientService;
    private final MiniRegisteredClientConverter registeredClientConverter;
    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        return null;
    }
}
