package com.opv2.zapt.module.bpm.framework.flowable.core.candidate.strategy;

import com.opv2.zapt.framework.common.util.string.StrUtils;
import com.opv2.zapt.module.bpm.framework.flowable.core.candidate.BpmTaskCandidateStrategy;
import com.opv2.zapt.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
import com.opv2.zapt.module.system.api.dept.DeptApi;
import com.opv2.zapt.module.system.api.dept.dto.DeptRespDTO;
import jakarta.annotation.Resource;
import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static com.opv2.zapt.framework.common.util.collection.CollectionUtils.convertSet;

/**
 * 部门的负责人 {@link BpmTaskCandidateStrategy} 实现类
 *
 * @author kyle
 */
@Component
public class BpmTaskCandidateDeptLeaderStrategy implements BpmTaskCandidateStrategy {

    @Resource
    private DeptApi deptApi;

    @Override
    public BpmTaskCandidateStrategyEnum getStrategy() {
        return BpmTaskCandidateStrategyEnum.DEPT_LEADER;
    }

    @Override
    public void validateParam(String param) {
        Set<Long> deptIds = StrUtils.splitToLongSet(param);
        deptApi.validateDeptList(deptIds);
    }

    @Override
    public Set<Long> calculateUsers(DelegateExecution execution, String param) {
        Set<Long> deptIds = StrUtils.splitToLongSet(param);
        List<DeptRespDTO> depts = deptApi.getDeptList(deptIds);
        return convertSet(depts, DeptRespDTO::getLeaderUserId);
    }

}