package com.sech.framework.business.admin.repository;

import com.sech.framework.business.admin.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer>,
        QueryDslPredicateExecutor<UserRole> {

}
