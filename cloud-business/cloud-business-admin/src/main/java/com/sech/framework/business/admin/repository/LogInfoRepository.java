package com.sech.framework.business.admin.repository;

import com.sech.framework.business.admin.domain.LogInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface LogInfoRepository extends JpaRepository<LogInfo, Long>,
        QueryDslPredicateExecutor<LogInfo> {

}
