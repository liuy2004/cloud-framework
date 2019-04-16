package com.sech.framework.business.admin.repository;

import com.sech.framework.business.admin.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface RoleRepository extends JpaRepository<Role, Integer>,
        QueryDslPredicateExecutor<Role> {

    Role findRoleByRoleCode(String roleCode);

}
