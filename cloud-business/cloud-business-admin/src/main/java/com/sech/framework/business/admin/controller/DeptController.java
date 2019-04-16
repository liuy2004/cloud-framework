package com.sech.framework.business.admin.controller;

import com.sech.framework.business.admin.service.DeptService;
import com.sech.framework.business.commons.permission.Functional;
import com.sech.framework.business.commons.permission.Module;
import com.sech.framework.business.commons.tree.DeptTree;
import com.sech.framework.business.commons.web.BaseController;
import com.sech.framework.business.commons.web.aop.PrePermissions;
import com.sech.framework.core.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门管理服务
 *
 * @author sech.io
 */
@RestController
@RequestMapping("/dept")
@PrePermissions(value = Module.DEPT)
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    @GetMapping(value = "/tree")
    @PrePermissions(value = Functional.VIEW)
    public R<List<DeptTree>> getDeptTreeList() {
        return new R<List<DeptTree>>().data(deptService.getDeptTreeList());
    }

}
