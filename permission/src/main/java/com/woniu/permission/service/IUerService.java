package com.woniu.permission.service;

import com.github.pagehelper.PageInfo;
import com.woniu.permission.entity.User;

public interface IUerService {

    User findUserByKey(int id);


    User findUserByLogin(User user);

    PageInfo<User> findUserPage(Integer now, Integer size, String name);

    void saveUser(User user);

    void saveUserRole(Integer userid, Integer[] leftRoles);

    void removeUserRole(Integer userid, Integer[] rightRoles);
}
