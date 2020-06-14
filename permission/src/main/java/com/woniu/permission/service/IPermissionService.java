package com.woniu.permission.service;

import com.woniu.permission.entity.Permission;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author wugd
 * @create 2020/4/1
 * @since 1.0.0
 */
public interface IPermissionService {


    List<Permission> findAll();

    void saveNode(Permission permission);

    List<Permission> findPerByUser(Integer id);
}
