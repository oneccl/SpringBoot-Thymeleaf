package com.cc.springbootthymeleaf.service;

import com.cc.springbootthymeleaf.pojo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/12/1
 * Time: 9:18
 * Description:
 */
public interface UserService {

    User findById(Integer id);

    User findCheck(User user);

    List<User> findUsers(String name, Integer role);

    Boolean delUser(Integer id);

    Boolean addUser(User user);

    Boolean updateUser(User user);

}
