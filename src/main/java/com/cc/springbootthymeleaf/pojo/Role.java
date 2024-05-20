package com.cc.springbootthymeleaf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/11/30
 * Time: 20:11
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Integer roleId;
    private String roleCode;
    private String roleName;

}
