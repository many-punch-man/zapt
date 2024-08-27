package com.opv2.zapt.module.system.api.logger;

import com.opv2.zapt.framework.common.pojo.PageResult;
import com.opv2.zapt.framework.common.util.object.BeanUtils;
import com.opv2.zapt.module.system.api.logger.dto.OperateLogCreateReqDTO;
import com.opv2.zapt.module.system.api.logger.dto.OperateLogPageReqDTO;
import com.opv2.zapt.module.system.api.logger.dto.OperateLogRespDTO;
import com.opv2.zapt.module.system.dal.dataobject.logger.OperateLogDO;
import com.opv2.zapt.module.system.service.logger.OperateLogService;
import com.fhs.core.trans.anno.TransMethodResult;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 操作日志 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;

    @Override
    @Async
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
    }

    @Override
    @TransMethodResult
    public PageResult<OperateLogRespDTO> getOperateLogPage(OperateLogPageReqDTO pageReqDTO) {
        PageResult<OperateLogDO> operateLogPage = operateLogService.getOperateLogPage(pageReqDTO);
        return BeanUtils.toBean(operateLogPage, OperateLogRespDTO.class);
    }

}
