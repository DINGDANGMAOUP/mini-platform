package com.dingdangmaoup.mini.platform.infrastructure.gateway.mapper;

import com.dingdangmaoup.mini.platform.domain.model.MiniAuthorization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
* @author dzhao1
* @description 针对表【mini_authorization】的数据库操作Mapper
* @createDate 2023-04-28 13:15:39
* @Entity com.dingdangmaoup.mini.platform.domain.model.MiniAuthorization
*/
public interface MiniAuthorizationMapper extends BaseMapper<MiniAuthorization> {

    Optional<MiniAuthorization> findByStateOrAuthorizationCodeValueOrAccessTokenValueOrRefreshTokenValue(@Param("token") String token);

    Optional<MiniAuthorization> findByState(@Param("token")String token);

    Optional<MiniAuthorization> findByAuthorizationCodeValue(@Param("token") String token);

    Optional<MiniAuthorization> findByAccessTokenValue(@Param("token") String token);

    Optional<MiniAuthorization> findByRefreshTokenValue(@Param("token") String token);

    Optional<MiniAuthorization> findByOidcIdTokenValue(@Param("token") String token);
}




