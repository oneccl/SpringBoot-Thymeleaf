package com.cc.springbootthymeleaf.service.impl;

import com.cc.springbootthymeleaf.dao.UserMapper;
import com.cc.springbootthymeleaf.pojo.User;
import com.cc.springbootthymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/12/1
 * Time: 9:19
 * Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.queryById(id);
    }

    @Override
    public User findCheck(User user) {
        return userMapper.queryCheck(user);
    }

    @Override
    public List<User> findUsers(String name, Integer role) {
        return userMapper.queryUsers(name,role);
    }

    @Override
    public Boolean delUser(Integer id) {
        return userMapper.delete(id) > 0;
    }

    @Override
    public Boolean addUser(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public Boolean updateUser(User user) {
        return userMapper.update(user) > 0;
    }

}
