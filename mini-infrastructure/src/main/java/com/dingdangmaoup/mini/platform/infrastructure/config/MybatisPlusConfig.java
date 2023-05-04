package com.dingdangmaoup.mini.platform.infrastructure.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * mybatis +配置
 *
 * @author dzhao1
 * @date 2022/12/07
 */
@MapperScan("com.dingdangmaoup.mini.platform.infrastructure.gateway.mapper")
@Configuration
public class MybatisPlusConfig {




	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		// 分页
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
		// 乐观锁
		interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
		// 防止全表更新与删除
		interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
		return interceptor;
	}

}
