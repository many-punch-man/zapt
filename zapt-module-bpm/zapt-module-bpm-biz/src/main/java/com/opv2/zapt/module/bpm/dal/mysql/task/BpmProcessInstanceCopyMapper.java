package com.opv2.zapt.module.bpm.dal.mysql.task;

import com.opv2.zapt.framework.common.pojo.PageResult;
import com.opv2.zapt.framework.mybatis.core.mapper.BaseMapperX;
import com.opv2.zapt.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.opv2.zapt.module.bpm.controller.admin.task.vo.instance.BpmProcessInstanceCopyPageReqVO;
import com.opv2.zapt.module.bpm.dal.dataobject.task.BpmProcessInstanceCopyDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BpmProcessInstanceCopyMapper extends BaseMapperX<BpmProcessInstanceCopyDO> {

    default PageResult<BpmProcessInstanceCopyDO> selectPage(Long loginUserId, BpmProcessInstanceCopyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmProcessInstanceCopyDO>()
                .eqIfPresent(BpmProcessInstanceCopyDO::getUserId, loginUserId)
                .likeIfPresent(BpmProcessInstanceCopyDO::getProcessInstanceName, reqVO.getProcessInstanceName())
                .betweenIfPresent(BpmProcessInstanceCopyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmProcessInstanceCopyDO::getId));
    }

}
