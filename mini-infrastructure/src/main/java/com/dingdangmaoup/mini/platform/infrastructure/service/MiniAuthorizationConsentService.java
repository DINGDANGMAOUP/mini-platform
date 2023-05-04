package com.dingdangmaoup.mini.platform.infrastructure.service;

import com.dingdangmaoup.mini.platform.domain.model.MiniAuthorizationConsent;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author dzhao1
* @description 针对表【mini_authorization_consent】的数据库操作Service
* @createDate 2023-05-04 14:00:59
*/
public interface MiniAuthorizationConsentService extends IService<MiniAuthorizationConsent> {

    void removeByClientIdAndPrincipalName(String registeredClientId, String principalName);

    MiniAuthorizationConsent getByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
}
