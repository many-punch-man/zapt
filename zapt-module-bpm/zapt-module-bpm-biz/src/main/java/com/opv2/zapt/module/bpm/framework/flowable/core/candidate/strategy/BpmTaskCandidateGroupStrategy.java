package com.opv2.zapt.module.bpm.framework.flowable.core.candidate.strategy;

import com.opv2.zapt.framework.common.util.string.StrUtils;
import com.opv2.zapt.module.bpm.dal.dataobject.definition.BpmUserGroupDO;
import com.opv2.zapt.module.bpm.framework.flowable.core.candidate.BpmTaskCandidateStrategy;
import com.opv2.zapt.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
import com.opv2.zapt.module.bpm.service.definition.BpmUserGroupService;
import jakarta.annotation.Resource;
import org.flowable.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.opv2.zapt.framework.common.util.collection.CollectionUtils.convertSetByFlatMap;

/**
 * 用户组 {@link BpmTaskCandidateStrategy} 实现类
 *
 * @author kyle
 */
@Component
public class BpmTaskCandidateGroupStrategy implements BpmTaskCandidateStrategy {

    @Resource
    private BpmUserGroupService userGroupService;

    @Override
    public BpmTaskCandidateStrategyEnum getStrategy() {
        return BpmTaskCandidateStrategyEnum.USER_GROUP;
    }

    @Override
    public void validateParam(String param) {
        Set<Long> groupIds = StrUtils.splitToLongSet(param);
        userGroupService.getUserGroupList(groupIds);
    }

    @Override
    public Set<Long> calculateUsers(DelegateExecution execution, String param) {
        Set<Long> groupIds = StrUtils.splitToLongSet(param);
        List<BpmUserGroupDO> groups = userGroupService.getUserGroupList(groupIds);
        return convertSetByFlatMap(groups, BpmUserGroupDO::getUserIds, Collection::stream);
    }

}