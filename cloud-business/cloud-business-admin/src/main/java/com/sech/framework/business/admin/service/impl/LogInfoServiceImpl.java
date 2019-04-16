package com.sech.framework.business.admin.service.impl;

import com.sech.framework.business.admin.domain.LogInfo;
import com.sech.framework.business.admin.domain.QLogInfo;
import com.sech.framework.business.admin.repository.LogInfoRepository;
import com.sech.framework.business.admin.service.LogInfoService;
import com.sech.framework.business.commons.beans.PageBean;
import com.sech.framework.business.commons.beans.PageParams;
import com.sech.framework.business.commons.utils.PageUtils;
import com.sech.framework.core.utils.StringHelper;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoRepository logInfoRepository;

    @Override
    @Transactional
    public void saveOrUpdate(LogInfo logInfo) {

        if (null == logInfo) return;

        logInfoRepository.save(logInfo);

    }

    @Override
    public PageBean<LogInfo> findAll(PageParams pageParams, LogInfo logInfo) {
        QLogInfo qLogInfo = QLogInfo.logInfo;
        // 用户名查询条件
        Predicate qServiceIdPredicate = null;
        if (null != logInfo) {
            if (StringHelper.isNotBlank(logInfo.getServiceId())) {
                qServiceIdPredicate = qLogInfo.serviceId.like("%" + logInfo.getServiceId().trim()
                        + "%");
            }
        }

        Predicate predicate = qLogInfo.statu.eq(0).and(qServiceIdPredicate);

        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "id"));
        PageRequest pageRequest = PageUtils.of(pageParams, sort);
        Page<LogInfo> pageList = logInfoRepository.findAll(predicate, pageRequest);
        return PageUtils.of(pageList);
    }

    @Override
    @Transactional
    public boolean delById(Long id) {
        if (null == id || id <= 0) return Boolean.FALSE;

        logInfoRepository.delete(id);

        return Boolean.TRUE;
    }

}
