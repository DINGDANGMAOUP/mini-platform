package com.dingdangmaoup.mini.platform.infrastructure.authorization;

import com.dingdangmaoup.mini.platform.domain.model.MiniRegisteredClient;
import com.dingdangmaoup.mini.platform.infrastructure.mapstruct.MiniRegisteredClientConverter;
import com.dingdangmaoup.mini.platform.infrastructure.service.MiniRegisteredClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@AllArgsConstructor
@Repository
public class CustomRegisteredClientService implements RegisteredClientRepository {
    private final MiniRegisteredClientService registeredClientService;
    private final MiniRegisteredClientConverter registeredClientConverter;
    @Override
    public void save(RegisteredClient registeredClient) {
        Assert.notNull(registeredClient, "registeredClient cannot be null");
        MiniRegisteredClient client = registeredClientConverter.toMiniRegisteredClient(registeredClient);
        registeredClientService.save(client);
    }

    @Override
    public RegisteredClient findById(String id) {
        Assert.hasText(id, "id cannot be empty");
        MiniRegisteredClient client = registeredClientService.getById(id);
        return registeredClientConverter.toRegisteredClient(client);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Assert.hasText(clientId, "clientId cannot be empty");
        MiniRegisteredClient client = registeredClientService.findByClientId(clientId);
        return registeredClientConverter.toRegisteredClient(client);
    }
}
