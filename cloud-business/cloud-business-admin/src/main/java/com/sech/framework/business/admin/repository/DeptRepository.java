package com.sech.framework.business.admin.repository;

import com.sech.framework.business.admin.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface DeptRepository extends JpaRepository<Dept, Integer>,
        QueryDslPredicateExecutor<Dept> {

}
