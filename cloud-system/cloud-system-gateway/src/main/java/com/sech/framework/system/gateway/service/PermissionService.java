package com.sech.framework.system.gateway.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface PermissionService {

    /**
     * 判断请求是否有权限
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
