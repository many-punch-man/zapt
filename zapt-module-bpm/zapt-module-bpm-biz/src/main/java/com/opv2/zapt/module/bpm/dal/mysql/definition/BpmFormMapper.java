package com.opv2.zapt.module.bpm.dal.mysql.definition;


import com.opv2.zapt.module.bpm.controller.admin.definition.vo.form.BpmFormPageReqVO;
import com.opv2.zapt.module.bpm.dal.dataobject.definition.BpmFormDO;
import com.opv2.zapt.framework.common.pojo.PageResult;
import com.opv2.zapt.framework.mybatis.core.mapper.BaseMapperX;
import com.opv2.zapt.framework.mybatis.core.query.QueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 动态表单 Mapper
 *
 * @author 风里雾里
 */
@Mapper
public interface BpmFormMapper extends BaseMapperX<BpmFormDO> {

    default PageResult<BpmFormDO> selectPage(BpmFormPageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<BpmFormDO>()
                .likeIfPresent("name", reqVO.getName())
                .orderByDesc("id"));
    }

}
