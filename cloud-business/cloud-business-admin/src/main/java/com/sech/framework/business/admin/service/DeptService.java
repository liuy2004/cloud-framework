package com.sech.framework.business.admin.service;

import com.sech.framework.business.commons.tree.DeptTree;

import java.util.List;

public interface DeptService {

    /**
     * 得到部门树形列表数据
     */
    List<DeptTree> getDeptTreeList();

}
