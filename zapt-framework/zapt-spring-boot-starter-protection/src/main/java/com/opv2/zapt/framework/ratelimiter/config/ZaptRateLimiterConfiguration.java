package com.opv2.zapt.framework.ratelimiter.config;

import com.opv2.zapt.framework.ratelimiter.core.aop.RateLimiterAspect;
import com.opv2.zapt.framework.ratelimiter.core.keyresolver.RateLimiterKeyResolver;
import com.opv2.zapt.framework.ratelimiter.core.keyresolver.impl.*;
import com.opv2.zapt.framework.ratelimiter.core.redis.RateLimiterRedisDAO;
import com.opv2.zapt.framework.redis.config.ZaptRedisAutoConfiguration;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@AutoConfiguration(after = ZaptRedisAutoConfiguration.class)
public class ZaptRateLimiterConfiguration {

    @Bean
    public RateLimiterAspect rateLimiterAspect(List<RateLimiterKeyResolver> keyResolvers, RateLimiterRedisDAO rateLimiterRedisDAO) {
        return new RateLimiterAspect(keyResolvers, rateLimiterRedisDAO);
    }

    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public RateLimiterRedisDAO rateLimiterRedisDAO(RedissonClient redissonClient) {
        return new RateLimiterRedisDAO(redissonClient);
    }

    // ========== 各种 RateLimiterRedisDAO Bean ==========

    @Bean
    public DefaultRateLimiterKeyResolver defaultRateLimiterKeyResolver() {
        return new DefaultRateLimiterKeyResolver();
    }

    @Bean
    public UserRateLimiterKeyResolver userRateLimiterKeyResolver() {
        return new UserRateLimiterKeyResolver();
    }

    @Bean
    public ClientIpRateLimiterKeyResolver clientIpRateLimiterKeyResolver() {
        return new ClientIpRateLimiterKeyResolver();
    }

    @Bean
    public ServerNodeRateLimiterKeyResolver serverNodeRateLimiterKeyResolver() {
        return new ServerNodeRateLimiterKeyResolver();
    }

    @Bean
    public ExpressionRateLimiterKeyResolver expressionRateLimiterKeyResolver() {
        return new ExpressionRateLimiterKeyResolver();
    }

}
