package com.sech.framework.business.admin.service.impl;

import com.sech.framework.business.admin.cache.AdminCacheKey;
import com.sech.framework.business.admin.domain.Dept;
import com.sech.framework.business.admin.domain.QDept;
import com.sech.framework.business.admin.repository.DeptRepository;
import com.sech.framework.business.admin.service.DeptService;
import com.sech.framework.business.commons.tree.DeptTree;
import com.sech.framework.business.commons.tree.TreeUtil;
import com.sech.framework.business.commons.web.jpa.JPAFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeptServiceImpl extends JPAFactoryImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    @Cacheable(value = AdminCacheKey.DEPT_INFO, key = "'dept_list'")
    public List<DeptTree> getDeptTreeList() {
        QDept dept = QDept.dept;
        List<Dept> list = this.queryFactory.selectFrom(dept).where(dept.statu.eq(0)).fetch();
        if (null == list || list.size() == 0) return new ArrayList<DeptTree>();

        return getDeptTree(list, 0);
    }

    private List<DeptTree> getDeptTree(List<Dept> list, int rootId) {
        List<DeptTree> treeList = new ArrayList<DeptTree>();
        for (Dept dept : list) {
            // 排除父节点和自己节点相同的数据
            if (dept.getPid().intValue() == dept.getId().intValue()) continue;
            DeptTree node = new DeptTree();
            node.setId(dept.getId() + "");
            node.setPid(dept.getPid() + "");
            node.setName(dept.getDeptName());
            treeList.add(node);
        }
        return TreeUtil.build(treeList, "0");
    }

}
