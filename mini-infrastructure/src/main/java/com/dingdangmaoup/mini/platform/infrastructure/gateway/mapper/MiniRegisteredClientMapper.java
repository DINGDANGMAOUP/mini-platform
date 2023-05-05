package com.dingdangmaoup.mini.platform.infrastructure.gateway.mapper;

import com.dingdangmaoup.mini.platform.domain.model.MiniRegisteredClient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author dzhao1
* @description 针对表【mini_registered_client】的数据库操作Mapper
* @createDate 2023-05-05 10:37:26
* @Entity com.dingdangmaoup.mini.platform.domain.model.MiniRegisteredClient
*/
public interface MiniRegisteredClientMapper extends BaseMapper<MiniRegisteredClient> {

    MiniRegisteredClient findByClientId(@Param("clientId") String clientId);
}




