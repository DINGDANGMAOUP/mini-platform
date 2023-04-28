package com.dingdangmaoup.mini.platform.infrastructure.gateway;

import com.dingdangmaoup.mini.platform.domain.gateway.UserGateway;
import com.dingdangmaoup.mini.platform.infrastructure.service.MiniAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGatewayImpl implements UserGateway {
    @Autowired
    MiniAuthorizationService miniAuthorizationService;

    public List test(){
        return miniAuthorizationService.list();
    }

}
