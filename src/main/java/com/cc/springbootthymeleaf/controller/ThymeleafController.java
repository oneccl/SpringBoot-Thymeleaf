package com.cc.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/11/30
 * Time: 20:25
 * Description:
 */
@Controller
public class ThymeleafController {
    // 使用Thymeleaf模板引擎

    // 访问templates目录下的资源(第一启动项)
//    @GetMapping("/")
//    public String enter(){
//        return "thymeleafTest";
//    }

    @GetMapping("/thymeleafLogin.do")
    public String thymeleafLogin(){
        return "thymeleafLogin";
    }

}
