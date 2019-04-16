package com.sech.framework.business.admin.service;

import com.sech.framework.business.admin.beans.UserBean;
import com.sech.framework.business.admin.beans.UserForm;
import com.sech.framework.business.admin.domain.User;
import com.sech.framework.business.commons.beans.PageBean;
import com.sech.framework.business.commons.beans.PageParams;
import com.sech.framework.core.beans.system.AuthUser;

public interface UserService {

    public AuthUser findUserByUsername(String username);

    public User findUserByUsername(String username, boolean isLoadRole);

    public AuthUser findUserByMobile(String mobile);

    public void saveImageCode(String randomStr, String text);

    public UserBean findUserInfo(AuthUser user);

    public AuthUser findByUserId(String userId);

    public PageBean<User> findAll(PageParams pageParams, User user);

    public Boolean delByUserId(Integer userId);

    public boolean addUserAndRole(User user, Integer roleId);

    public boolean updateUserAndRole(UserForm userForm);

    public boolean updateUser(User user);

}
