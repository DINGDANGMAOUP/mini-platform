package com.dingdangmaoup.mini.platform.infrastructure.gateway;

import com.dingdangmaoup.mini.platform.domain.gateway.UserGateway;
import com.dingdangmaoup.mini.platform.infrastructure.service.MiniAuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserGatewayImpl implements UserGateway {
    private final MiniAuthorizationService miniAuthorizationService;


}
