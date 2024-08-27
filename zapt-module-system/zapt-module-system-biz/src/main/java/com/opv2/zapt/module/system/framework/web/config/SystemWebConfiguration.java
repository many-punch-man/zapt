package com.opv2.zapt.module.system.framework.web.config;

import com.opv2.zapt.framework.swagger.config.ZaptSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * system 模块的 web 组件的 Configuration
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
public class SystemWebConfiguration {

    /**
     * system 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi systemGroupedOpenApi() {
        return ZaptSwaggerAutoConfiguration.buildGroupedOpenApi("system");
    }

}
