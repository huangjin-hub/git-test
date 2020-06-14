package com.woniu.permission.service;

import com.github.pagehelper.PageInfo;
import com.woniu.permission.entity.Role;

import java.util.List;

public interface IRoleService {


    PageInfo<Role> findRolePage(Integer now, Integer size , String name);

    List<Role> findAllRole();

    void saveRolePer(Integer roleid, Integer[] perids);

    Role findRoleByKey(int id);
}
