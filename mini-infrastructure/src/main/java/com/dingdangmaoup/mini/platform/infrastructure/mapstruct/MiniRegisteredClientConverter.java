package com.dingdangmaoup.mini.platform.infrastructure.mapstruct;

import com.dingdangmaoup.mini.platform.domain.model.MiniRegisteredClient;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

@Mapper(componentModel = "spring")
public interface MiniRegisteredClientConverter {
    /**
     * @description 将【RegisteredClient】转换为【MiniRegisteredClient】
     */
    @Mapping(target = "postLogoutRedirectUris")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "isDelete", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "updateBy", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "createBy", ignore = true)
    MiniRegisteredClient toMiniRegisteredClient(RegisteredClient registeredClient);
}
