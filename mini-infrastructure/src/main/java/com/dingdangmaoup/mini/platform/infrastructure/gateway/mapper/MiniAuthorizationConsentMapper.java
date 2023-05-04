package com.dingdangmaoup.mini.platform.infrastructure.gateway.mapper;

import com.dingdangmaoup.mini.platform.domain.model.MiniAuthorizationConsent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author dzhao1
* @description 针对表【mini_authorization_consent】的数据库操作Mapper
* @createDate 2023-05-04 14:00:59
* @Entity com.dingdangmaoup.mini.platform.domain.model.MiniAuthorizationConsent
*/
public interface MiniAuthorizationConsentMapper extends BaseMapper<MiniAuthorizationConsent> {

    void removeByClientIdAndPrincipalName(@Param("registeredClientId") String registeredClientId,@Param("principalName") String principalName);

    MiniAuthorizationConsent getByRegisteredClientIdAndPrincipalName(@Param("registeredClientId") String registeredClientId,@Param("principalName") String principalName);
}




