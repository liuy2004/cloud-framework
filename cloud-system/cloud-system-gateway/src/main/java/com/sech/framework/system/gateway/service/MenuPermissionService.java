package com.sech.framework.system.gateway.service;

import com.sech.framework.core.beans.system.AuthPermission;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @author sech.io
 */
@FeignClient(name = "business-admin-server", fallback = MenuPermissionServiceFallback.class)
public interface MenuPermissionService {

    /**
     * 通过角色名查询菜单
     */
    @GetMapping(value = "/api/findMenuByRole/{roleCode}")
    Set<AuthPermission> findMenuByRole(@PathVariable("roleCode") String roleCode);

}
