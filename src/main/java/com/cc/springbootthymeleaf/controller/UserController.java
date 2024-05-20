package com.cc.springbootthymeleaf.controller;

import com.cc.springbootthymeleaf.pojo.Role;
import com.cc.springbootthymeleaf.pojo.User;
import com.cc.springbootthymeleaf.service.RoleService;
import com.cc.springbootthymeleaf.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2022/12/1
 * Time: 8:41
 * Description:
 */

// Spring boot使用官方推荐的Thymeleaf(百里香叶)模板引擎

/*
1、Thymeleaf: 是一个Java库和模板引擎，遵循解耦，以html作为模板页
2、JSP和Thymeleaf的对比：
   1）JSP必须依赖Tomcat运行，不能直接运行在浏览器中
   2）html可以运行在浏览器，但不能接收控制器传递的数据
   3）Thymeleaf使用html既保留了页面可以直接在浏览器运行，又实现了JSP(el,jstl)动态数据显示的功能
3、Thymeleaf的使用
   1）在html标签中引入Thymeleaf命名空间(可不引入)
     <html xmlns:th="http://www.thymeleaf.org" lang="en">
   2）必要时，引入css库和js库：
     <link th:href="@{/font-awesome/css/font-awesome.css}" rel="stylesheet"/>
     <script type="text/javascript" th:src="@{/js/jquery-1.11.2.min.js}"></script>
4、Thymeleaf常用语法
 (1)标准表达式
   1）变量表达式：${变量名}
   2）链接URL表达式：@{/资源名(参数1=${值1},...)}
 (2)内置对象
   1）#session：HttpSession对象(仅限Web Context)
   2）#request：HttpServletRequest对象(仅限Web Context)
   3）#response：HttpServletResponse对象(仅限Web Context)
 (3)常用th标签
   1）th:text="${}" 动态文本替换(赋值)
   2）th:object="${session.对象}" 动态对象替换
   3）th:value="${值}" 属性赋值
   4）th:switch="${变量}"
      th:case="${变量值}" 选择、分支
   5）th:include="" 引入
   6）th:selected="${boolean表达式}" 选中
   7）th:href="@{/资源名(参数1=${值1},...)}" 或
      th:src="@{/资源名(参数1=${值1},...)}" 地址链接URL
   8）th:if="${boolean表达式}" 判断
   9）th:action="@{/资源名(参数1=${值1},...)}" 表单提交
   10）th:each="变量名:${集合}" 循环遍历
   11）th:inline 内联JS(在js中使用域中的变量)
    ① 在script标签中添加javascript模板：<script th:inline="javascript">
    ② 使用后台保存在域中的值：[[${变量名}]]
5、Thymeleaf中字符串的拼接
   如：链接url表达式(字面值使用单引号)：
   方式1：使用标准表达式："@{资源名(参数1=${值1},...)}"
   方式2：使用+拼接：" '资源名?参数='+${值} "
6、Thymeleaf中的三目/三元运算
   例：<span th:value="${user.gender} == 1" ? '男':'女' "></span>
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    // 第一启动项：通过后台访问templates目录下的登录页面(login.html)
    @GetMapping("/")
    public String login(){
        return "login";
    }

    /*
    Model域：只能将数据保存到返回的页面
    session域：保存的数据所有页面可共享，当且仅当用户退出登录时数据销毁
    application域：保存的数据所有页面可共享，当且仅当服务器关闭时数据销毁
     */
    // 登录核对
    @PostMapping("/check.do")
    public String check(User user, HttpSession session){
        User checkedUser = userService.findCheck(user);
        if (checkedUser != null){
            // 使用session作用域，用户退出登录时数据销毁
            // html页面从session域中获取数据：session.name值/key值
            session.setAttribute("loginUser",checkedUser);
            return "main";
        }
        return "login";
    }

    // 查询用户
    @GetMapping("/getUsers.do")
    public String getUsers(Model model,String name,Integer role,Integer pageNo){
        // 点击用户管理时，pageNo为null
        if (pageNo == null){
            pageNo = 1;
        }
        // 分页
        PageHelper.startPage(pageNo, 5);

        List<User> users = userService.findUsers(name,role);
        model.addAttribute("userList",users);

        PageInfo<User> pageInfo = new PageInfo<>(users);
        model.addAttribute("page",pageInfo);

        return "userList";
    }

    // 添加用户
    @GetMapping("/toAdd.do")
    public String toAdd(){
        return "addUser";
    }
    @PostMapping("/add.do")
    public String add(User user){
        if (userService.addUser(user)){
            return "redirect:getUsers.do";
        }
        return "addUser";
    }

    // 删除用户
    @GetMapping("/remove.do")
    public String remove(Integer id){
        userService.delUser(id);
        return "forward:getUsers.do";
    }

    // 修改用户信息
    @GetMapping("/findById.do")
    public String findById(Model model, Integer id){
        User user = userService.findById(id);
        model.addAttribute("findUser",user);
        List<Role> roles = roleService.findAll();
        model.addAttribute("roleList",roles);
        return "userUpdate";
    }
    @PostMapping("/modify.do")
    public String modify(User user){
        if (userService.updateUser(user)){
            return "redirect:getUsers.do";
        }
        return "userUpdate";
    }

    // 查看用户信息
    @GetMapping("/show.do")
    public String show(Model model, Integer id){
        User user = userService.findById(id);
        model.addAttribute("showUser",user);
        return "userShow";
    }

}
