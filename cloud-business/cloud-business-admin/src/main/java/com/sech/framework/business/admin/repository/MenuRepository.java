package com.sech.framework.business.admin.repository;

import com.sech.framework.business.admin.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface MenuRepository extends JpaRepository<Menu, Integer>,
        QueryDslPredicateExecutor<Menu> {

}
