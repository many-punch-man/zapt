package com.opv2.zapt.module.system.api.dept;

import com.opv2.zapt.framework.common.util.object.BeanUtils;
import com.opv2.zapt.module.system.api.dept.dto.DeptRespDTO;
import com.opv2.zapt.module.system.dal.dataobject.dept.DeptDO;
import com.opv2.zapt.module.system.service.dept.DeptService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 部门 API 实现类
 *
 * @author 芋道源码
 */
@Service
public class DeptApiImpl implements DeptApi {

    @Resource
    private DeptService deptService;

    @Override
    public DeptRespDTO getDept(Long id) {
        DeptDO dept = deptService.getDept(id);
        return BeanUtils.toBean(dept, DeptRespDTO.class);
    }

    @Override
    public List<DeptRespDTO> getDeptList(Collection<Long> ids) {
        List<DeptDO> depts = deptService.getDeptList(ids);
        return BeanUtils.toBean(depts, DeptRespDTO.class);
    }

    @Override
    public void validateDeptList(Collection<Long> ids) {
        deptService.validateDeptList(ids);
    }

    @Override
    public List<DeptRespDTO> getChildDeptList(Long id) {
        List<DeptDO> childDeptList = deptService.getChildDeptList(id);
        return BeanUtils.toBean(childDeptList, DeptRespDTO.class);
    }

}
