package com.sech.framework.business.admin.service;

import com.sech.framework.business.admin.domain.Role;
import com.sech.framework.business.commons.beans.PageBean;
import com.sech.framework.business.commons.beans.PageParams;

import java.util.List;

public interface RoleService {

    List<Role> getRoleListByDeptId(Integer deptId);

    List<Role> getRoleList();

    PageBean<Role> findAll(PageParams pageParams, Role role);

    Role saveOrUpdate(Role role);

    boolean delById(Integer roleId);

    Role findRoleByCode(String roleCode);

}
