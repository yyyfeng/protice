package com.example.protice.service.impl;

import com.example.protice.mapper.UserMapper;
import com.example.protice.pojo.User;
import com.example.protice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UesrServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int login(String userName, String userPass) {
        List<User> users = userMapper.selectByName(userName);
        if(users.size()==0){
            return 0;
        }else{
            User user = users.get(0);
            if(user.getUserPass().equals(userPass)){
                return 1;
            }else{
                return 0;
            }
        }
    }

    @Override
    public int delete(int userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public String insertUser(User user) {
        //首先对获取的数据进行空值判断
        if (user.getUserName() == null || user.getUserName().equals("")) {
            log.error("用户名为空，添加失败！");
            return "ERROR";
        } else {
            if (user.getUserPass() == null || user.getUserPass().equals("")) {
                log.error("用户密码为空，添加失败！");
                return "ERROR";
            } else {
                if (user.getUserAge() == 0) {
                    log.error("用户年龄为空，添加失败！");
                    return "ERROR";
                } else {
                    if (user.getUserSex() == null || user.getUserSex().equals("")) {
                        log.error("用户性别为空，添加失败！");
                        return "ERROR";
                    } else {
                        if (user.getUserMobile() == null || user.getUserMobile().equals("")) {
                            log.error("用户电话为空，添加失败！");
                            return "ERROR";
                        } else {
                            log.info("用户信息完整，调用用户添加方法:insertUser()！");
                            int result = userMapper.insertUser(user.getUserName(), user.getUserPass(), user.getUserAge(), user.getUserSex(), user.getUserMobile());
                            if (result == 1) {
                                log.info("用户添加成功！");
                                return "SUCCESS";
                            } else {
                                log.error("用户添加失败！");
                                return "ERROR";
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public List<User> selectAll(String userName) {
        if(userName.equals("未匹配")){
            return userMapper.selectAll();
        }else{
            return userMapper.selectByName(userName);
        }
    }
}
