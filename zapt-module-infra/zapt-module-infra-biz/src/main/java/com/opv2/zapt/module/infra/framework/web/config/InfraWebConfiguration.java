package com.opv2.zapt.module.infra.framework.web.config;

import com.opv2.zapt.framework.swagger.config.ZaptSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * infra 模块的 web 组件的 Configuration
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
public class InfraWebConfiguration {

    /**
     * infra 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi infraGroupedOpenApi() {
        return ZaptSwaggerAutoConfiguration.buildGroupedOpenApi("infra");
    }

}
