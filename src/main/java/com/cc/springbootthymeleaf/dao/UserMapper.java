package com.cc.springbootthymeleaf.dao;

import com.cc.springbootthymeleaf.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/11/30
 * Time: 20:16
 * Description:
 */
@Repository
public interface UserMapper {

    User queryById(Integer id);

    User queryCheck(User user);

    List<User> queryUsers(String name, Integer role);

    Integer delete(Integer id);

    Integer insert(User user);

    Integer update(User user);

}
