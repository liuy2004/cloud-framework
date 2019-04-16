package com.sech.framework.business.admin.service.impl;

import com.sech.framework.business.admin.cache.AdminCacheKey;
import com.sech.framework.business.admin.domain.Module;
import com.sech.framework.business.admin.domain.QModule;
import com.sech.framework.business.admin.service.ModuleService;
import com.sech.framework.business.commons.web.jpa.JPAFactoryImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@CacheConfig(cacheNames = AdminCacheKey.MODULE_INFO)
@Component
public class ModuleServiceImpl extends JPAFactoryImpl implements ModuleService {

    @Override
    @Cacheable(key = "'module_list'")
    public List<Module> getAllList() {
        QModule qModule = QModule.module;

        return this.queryFactory.selectFrom(qModule).fetch();
    }

}
