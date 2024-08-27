package com.opv2.zapt.module.bpm.controller.admin.oa;

import com.opv2.zapt.framework.common.pojo.CommonResult;
import com.opv2.zapt.framework.common.pojo.PageResult;
import com.opv2.zapt.framework.common.util.object.BeanUtils;
import com.opv2.zapt.module.bpm.controller.admin.oa.vo.BpmOALeaveCreateReqVO;
import com.opv2.zapt.module.bpm.controller.admin.oa.vo.BpmOALeavePageReqVO;
import com.opv2.zapt.module.bpm.controller.admin.oa.vo.BpmOALeaveRespVO;
import com.opv2.zapt.module.bpm.dal.dataobject.oa.BpmOALeaveDO;
import com.opv2.zapt.module.bpm.service.oa.BpmOALeaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.opv2.zapt.framework.common.pojo.CommonResult.success;
import static com.opv2.zapt.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * OA 请假申请 Controller，用于演示自己存储数据，接入工作流的例子
 *
 * @author jason
 * @author 芋道源码
 */
@Tag(name = "管理后台 - OA 请假申请")
@RestController
@RequestMapping("/bpm/oa/leave")
@Validated
public class BpmOALeaveController {

    @Resource
    private BpmOALeaveService leaveService;

    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('bpm:oa-leave:create')")
    @Operation(summary = "创建请求申请")
    public CommonResult<Long> createLeave(@Valid @RequestBody BpmOALeaveCreateReqVO createReqVO) {
        return success(leaveService.createLeave(getLoginUserId(), createReqVO));
    }

    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('bpm:oa-leave:query')")
    @Operation(summary = "获得请假申请")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<BpmOALeaveRespVO> getLeave(@RequestParam("id") Long id) {
        BpmOALeaveDO leave = leaveService.getLeave(id);
        return success(BeanUtils.toBean(leave, BpmOALeaveRespVO.class));
    }

    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('bpm:oa-leave:query')")
    @Operation(summary = "获得请假申请分页")
    public CommonResult<PageResult<BpmOALeaveRespVO>> getLeavePage(@Valid BpmOALeavePageReqVO pageVO) {
        PageResult<BpmOALeaveDO> pageResult = leaveService.getLeavePage(getLoginUserId(), pageVO);
        return success(BeanUtils.toBean(pageResult, BpmOALeaveRespVO.class));
    }

}
