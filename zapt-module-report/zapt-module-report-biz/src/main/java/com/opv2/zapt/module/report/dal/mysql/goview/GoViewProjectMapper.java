package com.opv2.zapt.module.report.dal.mysql.goview;

import com.opv2.zapt.framework.common.pojo.PageParam;
import com.opv2.zapt.framework.common.pojo.PageResult;
import com.opv2.zapt.framework.mybatis.core.mapper.BaseMapperX;
import com.opv2.zapt.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.opv2.zapt.module.report.dal.dataobject.goview.GoViewProjectDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoViewProjectMapper extends BaseMapperX<GoViewProjectDO> {

    default PageResult<GoViewProjectDO> selectPage(PageParam reqVO, Long userId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GoViewProjectDO>()
                .eq(GoViewProjectDO::getCreator, userId)
                .orderByDesc(GoViewProjectDO::getId));
    }

}
