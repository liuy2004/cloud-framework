package com.sech.framework.system.auth.service;

import com.sech.framework.core.beans.system.AuthUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "business-admin-server", fallback = UserServiceFallback.class)
public interface UserService {

    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     */
    @GetMapping("/api/findUserByUsername/{username}")
    AuthUser findUserByUsername(@PathVariable("username") String username);

    /**
     * 通过手机号查询用户、角色信息
     */
    @GetMapping("/api/findUserByMobile/{mobile}")
    AuthUser findUserByMobile(@PathVariable("mobile") String mobile);

}
