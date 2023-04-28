package com.dingdangmaoup.mini.platform.infrastructure.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingdangmaoup.mini.platform.domain.model.MiniAuthorization;
import com.dingdangmaoup.mini.platform.infrastructure.service.MiniAuthorizationService;
import com.dingdangmaoup.mini.platform.infrastructure.gateway.mapper.MiniAuthorizationMapper;
import org.springframework.stereotype.Service;

/**
* @author dzhao1
* @description 针对表【mini_authorization】的数据库操作Service实现
* @createDate 2023-04-28 13:15:39
*/
@Service
public class MiniAuthorizationServiceImpl extends ServiceImpl<MiniAuthorizationMapper, MiniAuthorization>
    implements MiniAuthorizationService{

}




