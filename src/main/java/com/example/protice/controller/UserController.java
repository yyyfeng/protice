package com.example.protice.controller;

import com.example.protice.pojo.User;
import com.example.protice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public void  login(String userName, String userPass, HttpServletResponse response) throws IOException {
        log.info("userName"+userName+"userPass:"+userPass);
        int result = userService.login(userName, userPass);
        if(result==1 && userName.equals("admin")){
            response.sendRedirect("/userList");
        }else if(result==1 && !userName.equals("admin")){
            response.sendRedirect("success.html");
        }else{
            response.sendRedirect("error.html");
        }



    }

    //删除用户的方法
    @RequestMapping("/delUser")
    @ResponseBody
    public int delUser(int userId){
        log.info("获取到的用户ID:"+userId);
        int result=userService.delete(userId);
        return result;
    }


    //查询用户并返回列表的方法
    @RequestMapping("/userList")
    public String  userList( String userName,Model model){
        log.info("获取到的用户名："+userName);
        if(userName==null ||userName.equals("")){
            userName="未匹配";
        }
        List<User> list = userService.selectAll(userName);
        model.addAttribute("list",list);
        return "userList";
    }

    //添加用户的方法
    @RequestMapping("/insertUser")
    @Transactional
    public String  insertUser(User user, HttpServletResponse response,Model model ) throws IOException {
        log.info("获取的user:" + user);
        //调用添加用户的方法
        String res = userService.insertUser(user);
       /* if (res.equals("SUCCESS")) {
            response.sendRedirect("success.html");
        } else {
            response.sendRedirect("error.html");
        }*/
       model.addAttribute("result",res);
       return "result";

    }
}
