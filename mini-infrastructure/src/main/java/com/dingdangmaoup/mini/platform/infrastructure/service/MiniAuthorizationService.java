package com.dingdangmaoup.mini.platform.infrastructure.service;

import com.dingdangmaoup.mini.platform.domain.model.MiniAuthorization;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Optional;

/**
* @author dzhao1
* @description 针对表【mini_authorization】的数据库操作Service
* @createDate 2023-04-28 13:15:39
*/
public interface MiniAuthorizationService extends IService<MiniAuthorization> {
    Optional<MiniAuthorization> findByStateOrAuthorizationCodeValueOrAccessTokenValueOrRefreshTokenValue(String token);

    Optional<MiniAuthorization> findByState(String token);

    Optional<MiniAuthorization> findByAuthorizationCodeValue(String token);

    Optional<MiniAuthorization> findByAccessTokenValue(String token);

    Optional<MiniAuthorization> findByRefreshTokenValue(String token);

    Optional<MiniAuthorization> findByOidcIdTokenValue(String token);
}
