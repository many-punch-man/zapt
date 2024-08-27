package com.opv2.zapt.framework.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.util.ClassUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功后，提供文档相关的地址
 *
 * @author 芋道源码
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Value("${server.port:1023}")
    String serverPort ;

    @Override
    public void run(ApplicationArguments args) {
        ThreadUtil.execute(() -> {

            //获取本机的ip地址
            String hostAddress = null;
            try {
                hostAddress = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            String openapiStr = "http://" + hostAddress + ":"+serverPort+"/swagger-ui.html";
            String knife4Str = "http://" + hostAddress + ":"+serverPort+"/doc.html";

            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("\n----------------------------------------------------------\n\t" +
                            "项目启动成功！\n\t" +
                            "swagger文档: \t{} \n\t" +
                            "knife4j文档: \t{} \n\t" +
                            "前端地址：\thttp://localhost:3000 \n\t" +
                            "----------------------------------------------------------",
                    openapiStr,
                    knife4Str);
//
//            // 数据报表
//            if (isNotPresent("com.opv2.zapt.module.report.framework.security.config.SecurityConfiguration")) {
//                System.out.println("[报表模块 zapt-module-report - 已禁用][参考 https://doc.iocoder.cn/report/ 开启]");
//            }
//            // 工作流
//            if (isNotPresent("com.opv2.zapt.module.bpm.framework.flowable.config.BpmFlowableConfiguration")) {
//                System.out.println("[工作流模块 zapt-module-bpm - 已禁用][参考 https://doc.iocoder.cn/bpm/ 开启]");
//            }
//            // 商城系统
//            if (isNotPresent("com.opv2.zapt.module.trade.framework.web.config.TradeWebConfiguration")) {
//                System.out.println("[商城系统 zapt-module-mall - 已禁用][参考 https://doc.iocoder.cn/mall/build/ 开启]");
//            }
//            // ERP 系统
//            if (isNotPresent("com.opv2.zapt.module.erp.framework.web.config.ErpWebConfiguration")) {
//                System.out.println("[ERP 系统 zapt-module-erp - 已禁用][参考 https://doc.iocoder.cn/erp/build/ 开启]");
//            }
//            // CRM 系统
//            if (isNotPresent("com.opv2.zapt.module.crm.framework.web.config.CrmWebConfiguration")) {
//                System.out.println("[CRM 系统 zapt-module-crm - 已禁用][参考 https://doc.iocoder.cn/crm/build/ 开启]");
//            }
//            // 微信公众号
//            if (isNotPresent("com.opv2.zapt.module.mp.framework.mp.config.MpConfiguration")) {
//                System.out.println("[微信公众号 zapt-module-mp - 已禁用][参考 https://doc.iocoder.cn/mp/build/ 开启]");
//            }
//            // 支付平台
//            if (isNotPresent("com.opv2.zapt.module.pay.framework.pay.config.PayConfiguration")) {
//                System.out.println("[支付系统 zapt-module-pay - 已禁用][参考 https://doc.iocoder.cn/pay/build/ 开启]");
//            }
//            // AI 大模型
//            if (isNotPresent("com.opv2.zapt.module.ai.framework.web.config.AiWebConfiguration")) {
//                System.out.println("[AI 大模型 zapt-module-ai - 已禁用][参考 https://doc.iocoder.cn/ai/build/ 开启]");
//            }
        });
    }

    private static boolean isNotPresent(String className) {
        return !ClassUtils.isPresent(className, ClassUtils.getDefaultClassLoader());
    }

}
