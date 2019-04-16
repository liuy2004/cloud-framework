package com.sech.framework.system.auth.service;

import com.sech.framework.core.beans.system.AuthUser;
import com.sech.framework.core.utils.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService, Serializable {

    private static final long serialVersionUID = 5181442448895412779L;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringHelper.isBlank(username)) {
            throw new UsernameNotFoundException("用户不存在:"
                    + username);
        }

        AuthUser user = userService.findUserByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("用户不存在:" + username);
        }

        return new UserDetailsImpl(user);
    }

}
