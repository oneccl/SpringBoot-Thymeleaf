package com.cc.springbootthymeleaf.service.impl;

import com.cc.springbootthymeleaf.dao.RoleMapper;
import com.cc.springbootthymeleaf.pojo.Role;
import com.cc.springbootthymeleaf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/12/1
 * Time: 16:57
 * Description:
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.queryAll();
    }

}
