package com.example.protice.service;

import com.example.protice.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    int login(String userName,String UserPass);

    int  delete(int userId);

    String   insertUser(User user);


    List<User> selectAll(String userName);
}
