package com.woniu.permission.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.permission.entity.Role;
import com.woniu.permission.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author wugd
 * @create 2020/3/31
 * @since 1.0.0
 */
@Service
//@CacheConfig()
public class RoleServiceImpl implements IRoleService{

    @Autowired
    RoleMapper roleMapper ;
    @Override
    public PageInfo<Role> findRolePage(Integer now, Integer size, String name) {
        PageHelper.startPage(now,size);
        List<Role> lists = roleMapper.selectRolePage(name);
        return new PageInfo<Role>(lists);
    }

    @Override
    public List<Role> findAllRole() {
        return roleMapper.selectAll();
    }

    @Override
    public void saveRolePer(Integer roleid, Integer[] perids) {
        for (Integer id:perids) {
            roleMapper.insertRolePer(roleid,id) ;
        }
    }

    @Override
    @Cacheable(cacheNames = "roleService")
    public Role findRoleByKey(int id) {
        return roleMapper.selectRoleByKey(id);
    }
}
