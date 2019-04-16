package com.sech.framework.business.admin.service;

import com.sech.framework.business.admin.domain.LogInfo;
import com.sech.framework.business.commons.beans.PageBean;
import com.sech.framework.business.commons.beans.PageParams;

public interface LogInfoService {

    public void saveOrUpdate(LogInfo logInfo);

    /**
     * 日志列表数据
     */
    PageBean<LogInfo> findAll(PageParams pageParams, LogInfo logInfo);

    /**
     * 日志删除
     */
    boolean delById(Long id);
}
