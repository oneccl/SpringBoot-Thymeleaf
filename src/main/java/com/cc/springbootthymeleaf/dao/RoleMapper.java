package com.cc.springbootthymeleaf.dao;

import com.cc.springbootthymeleaf.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/12/1
 * Time: 16:53
 * Description:
 */
@Repository
public interface RoleMapper {

    List<Role> queryAll();

}
