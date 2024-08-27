package com.opv2.zapt.module.system.controller.admin.sms;

import com.opv2.zapt.framework.common.pojo.CommonResult;
import com.opv2.zapt.framework.common.util.servlet.ServletUtils;
import com.opv2.zapt.module.system.framework.sms.core.enums.SmsChannelEnum;
import com.opv2.zapt.module.system.service.sms.SmsSendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;

import static com.opv2.zapt.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 短信回调")
@RestController
@RequestMapping("/system/sms/callback")
public class SmsCallbackController {

    @Resource
    private SmsSendService smsSendService;

    @PostMapping("/aliyun")
    @PermitAll
    @Operation(summary = "阿里云短信的回调", description = "参见 https://help.aliyun.com/zh/sms/developer-reference/configure-delivery-receipts-1 文档")
    public CommonResult<Boolean> receiveAliyunSmsStatus(HttpServletRequest request) throws Throwable {
        String text = ServletUtils.getBody(request);
        smsSendService.receiveSmsStatus(SmsChannelEnum.ALIYUN.getCode(), text);
        return success(true);
    }

    @PostMapping("/tencent")
    @PermitAll
    @Operation(summary = "腾讯云短信的回调", description = "参见 https://cloud.tencent.com/document/product/382/59178 文档")
    public CommonResult<Boolean> receiveTencentSmsStatus(HttpServletRequest request) throws Throwable {
        String text = ServletUtils.getBody(request);
        smsSendService.receiveSmsStatus(SmsChannelEnum.TENCENT.getCode(), text);
        return success(true);
    }


    @PostMapping("/huawei")
    @PermitAll
    @Operation(summary = "华为云短信的回调", description = "参见 https://support.huaweicloud.com/api-msgsms/sms_05_0003.html 文档")
    public CommonResult<Boolean> receiveHuaweiSmsStatus(HttpServletRequest request) throws Throwable {
        String text = ServletUtils.getBody(request);
        smsSendService.receiveSmsStatus(SmsChannelEnum.HUAWEI.getCode(), text);
        return success(true);
    }

}
