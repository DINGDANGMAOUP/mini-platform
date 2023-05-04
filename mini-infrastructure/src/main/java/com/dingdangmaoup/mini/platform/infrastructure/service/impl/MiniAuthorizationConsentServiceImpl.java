package com.dingdangmaoup.mini.platform.infrastructure.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingdangmaoup.mini.platform.domain.model.MiniAuthorizationConsent;
import com.dingdangmaoup.mini.platform.infrastructure.gateway.mapper.MiniAuthorizationConsentMapper;
import com.dingdangmaoup.mini.platform.infrastructure.service.MiniAuthorizationConsentService;
import org.springframework.stereotype.Service;

/**
* @author dzhao1
* @description 针对表【mini_authorization_consent】的数据库操作Service实现
* @createDate 2023-05-04 14:00:59
*/
@Service
public class MiniAuthorizationConsentServiceImpl extends ServiceImpl<MiniAuthorizationConsentMapper, MiniAuthorizationConsent>
    implements MiniAuthorizationConsentService {

    @Override
    public void removeByClientIdAndPrincipalName(String registeredClientId, String principalName) {
        baseMapper.removeByClientIdAndPrincipalName(registeredClientId, principalName);
    }

    @Override
    public MiniAuthorizationConsent getByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName) {
       return baseMapper.getByRegisteredClientIdAndPrincipalName(registeredClientId, principalName);
    }
}




