package com.sech.framework.system.gateway.service;

import com.sech.framework.core.beans.system.AuthPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class MenuPermissionServiceFallback implements MenuPermissionService {

    @Override
    public Set<AuthPermission> findMenuByRole(String roleCode) {
        log.error("调用{}异常:{}", "findMenuByRole", roleCode);
        return null;
    }

}
