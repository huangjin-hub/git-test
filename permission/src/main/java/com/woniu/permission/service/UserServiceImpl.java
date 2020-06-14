package com.woniu.permission.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.permission.entity.User;
import com.woniu.permission.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl implements IUerService {

    @Autowired
    UserMapper userMapper ;

    @Override
    public User findUserByKey(int id) {
        return userMapper.selectUserByKey(id);
    }

    @Override
    public User findUserByLogin(User user) {
        return  userMapper.selectUserByLogin(user);
    }

    @Override
    public PageInfo<User> findUserPage(Integer now, Integer size, String name) {

        PageHelper.startPage(now,size);
        List<User> lists = userMapper.selectUserList(name);
        return new PageInfo<User>(lists);
    }

    @Override
    public void saveUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void saveUserRole(Integer userid, Integer[] leftRoles) {
        for (Integer i :leftRoles) {
            userMapper.insertUserRole(userid,i);
        }

    }

    @Override
    public void removeUserRole(Integer userid, Integer[] rightRoles) {
        for (Integer i :rightRoles) {
            userMapper.deleteUserRole(userid,i);
        }
    }
}
