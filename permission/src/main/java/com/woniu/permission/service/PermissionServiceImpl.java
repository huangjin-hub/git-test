package com.woniu.permission.service;

import com.woniu.permission.entity.Permission;
import com.woniu.permission.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author wugd
 * @create 2020/4/1
 * @since 1.0.0
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    PermissionMapper permissionMapper ;

    @Override
    public List<Permission> findAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public void saveNode(Permission permission) {
        permissionMapper.insertPermission(permission);
    }

    @Override
    public List<Permission> findPerByUser(Integer id) {
        return permissionMapper.selectPerByUser(id);
    }
}
