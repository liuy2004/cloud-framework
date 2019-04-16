package com.sech.framework.business.admin.repository;

import com.sech.framework.business.admin.domain.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface DictRepository extends JpaRepository<Dict, Integer>,
        QueryDslPredicateExecutor<Dict> {

}
