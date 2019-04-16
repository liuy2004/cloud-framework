package com.sech.framework.system.auth.component.ajax;

import com.sech.framework.system.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @author sech.io
 */
@Component
public class AjaxSecurityConfigurer extends
        SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationSuccessHandler jwtLoginSuccessHandler;

    @Autowired
    private UserService userService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        AjaxAuthenticationFilter ajaxAuthenticationFilter = new AjaxAuthenticationFilter();
        ajaxAuthenticationFilter.setAuthenticationManager(http
                .getSharedObject(AuthenticationManager.class));
        ajaxAuthenticationFilter.setAuthenticationSuccessHandler(jwtLoginSuccessHandler);

        AjaxAuthenticationProvider ajaxAuthenticationProvider = new AjaxAuthenticationProvider();
        ajaxAuthenticationProvider.setUserService(userService);
        http.authenticationProvider(ajaxAuthenticationProvider).addFilterAfter(
                ajaxAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
