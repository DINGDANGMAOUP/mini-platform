package com.dingdangmaoup.mini.platform.infrastructure.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingdangmaoup.mini.platform.domain.model.MiniRegisteredClient;
import com.dingdangmaoup.mini.platform.infrastructure.gateway.mapper.MiniRegisteredClientMapper;
import com.dingdangmaoup.mini.platform.infrastructure.service.MiniRegisteredClientService;
import org.springframework.stereotype.Service;

/**
* @author dzhao1
* @description 针对表【mini_registered_client】的数据库操作Service实现
* @createDate 2023-05-05 10:37:26
*/
@Service
public class MiniRegisteredClientServiceImpl extends ServiceImpl<MiniRegisteredClientMapper, MiniRegisteredClient>
    implements MiniRegisteredClientService {

    @Override
    public MiniRegisteredClient findByClientId(String clientId) {
        return baseMapper.findByClientId(clientId);
    }
}




