package com.cc.springbootthymeleaf.service;

import com.cc.springbootthymeleaf.pojo.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/12/1
 * Time: 16:56
 * Description:
 */
public interface RoleService {

    List<Role> findAll();

}
