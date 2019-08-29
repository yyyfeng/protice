package com.example.protice.service;

import com.example.protice.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String   insertUser(User user);
}
