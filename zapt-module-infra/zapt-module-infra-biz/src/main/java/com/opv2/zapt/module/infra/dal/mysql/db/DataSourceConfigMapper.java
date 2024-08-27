package com.opv2.zapt.module.infra.dal.mysql.db;

import com.opv2.zapt.framework.mybatis.core.mapper.BaseMapperX;
import com.opv2.zapt.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
