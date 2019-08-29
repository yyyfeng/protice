package com.example.protice.controller;

import com.example.protice.pojo.User;
import com.example.protice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    @Transactional
    public void insertUser(User user, HttpServletResponse response) throws IOException {
        log.info("获取的user:" + user);
        //调用添加用户的方法
        String res = userService.insertUser(user);
        if (res.equals("SUCCESS")) {
            response.sendRedirect("success.html");
        } else {
            response.sendRedirect("error.html");
        }
    }
}
