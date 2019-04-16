package com.sech.framework.system.gateway.filter;

import com.sech.framework.core.commons.constants.SecurityConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;

/**
 * @author sech.io 在RateLimitPreFilter 之前执行，否则会出现空指针问题
 */
@Component
public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime", System.currentTimeMillis());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null
                && !"anonymousUser".equals(authentication.getPrincipal().toString())) {
            ctx.addZuulRequestHeader(SecurityConstant.USER_HEADER, authentication.getName());
            ctx.addZuulRequestHeader(SecurityConstant.ROLE_HEADER, CollectionUtil.join(
                    authentication.getAuthorities(), ","));
        }
        return null;
    }
}
