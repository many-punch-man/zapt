package com.opv2.zapt.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${zapt.info.base-package}
@SpringBootApplication(scanBasePackages = {"${zapt.info.base-package}.server", "${zapt.info.base-package}.module"})
public class ZaptServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZaptServerApplication.class, args);
    }

}
