package com.opv2.zapt.module.system.controller.app.test;

import cn.hutool.core.date.DateUtil;
import com.opv2.zapt.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.security.PermitAll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/index")
    @Operation(summary = "获得地区树")
    @PermitAll
    public CommonResult<String> getAreaTree() {
        log.info("访问了测试请求接口-{}", DateUtil.format(LocalDateTime.now(),"HH:mm:ss"));
        return CommonResult.success("Hello, Nuxt!");
    }
}
