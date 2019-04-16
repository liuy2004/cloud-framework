package com.sech.framework.system.auth.service;

import com.sech.framework.core.beans.system.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceFallback implements UserService {

    @Override
    public AuthUser findUserByUsername(String username) {
        log.error("调用{}异常:{}", "findUserByUsername", username);
        return null;
    }

    @Override
    public AuthUser findUserByMobile(String mobile) {
        log.error("调用{}异常:{}", "findUserByMobile", mobile);
        return null;
    }

}
