package com.opv2.zapt.module.report.convert.goview;

import com.opv2.zapt.framework.common.pojo.PageResult;
import com.opv2.zapt.module.report.controller.admin.goview.vo.project.GoViewProjectCreateReqVO;
import com.opv2.zapt.module.report.controller.admin.goview.vo.project.GoViewProjectRespVO;
import com.opv2.zapt.module.report.controller.admin.goview.vo.project.GoViewProjectUpdateReqVO;
import com.opv2.zapt.module.report.dal.dataobject.goview.GoViewProjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoViewProjectConvert {

    GoViewProjectConvert INSTANCE = Mappers.getMapper(GoViewProjectConvert.class);

    GoViewProjectDO convert(GoViewProjectCreateReqVO bean);

    GoViewProjectDO convert(GoViewProjectUpdateReqVO bean);

    GoViewProjectRespVO convert(GoViewProjectDO bean);

    PageResult<GoViewProjectRespVO> convertPage(PageResult<GoViewProjectDO> page);

}
