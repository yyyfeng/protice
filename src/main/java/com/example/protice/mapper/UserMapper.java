package com.example.protice.mapper;

import com.example.protice.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {


    @Delete("delete  from user  where  userId=#{userId}")
    int deleteUser(@Param("userId") int userId);

    @Select("select * from user where userName=#{userName}")
    List<User> selectByName(@Param("userName") String userName);

    @Select("select * from user ")
    List<User> selectAll();


    @Insert("insert into user(userName,userPass,userAge,userSex,userMobile) values(#{userName},#{userPass},#{userAge},#{userSex},#{userMobile} )")
    int insertUser(@Param("userName") String  userName, @Param("userPass") String  userPass,@Param("userAge") int  userAge, @Param("userSex") String userSex,
                   @Param("userMobile") String userMobile);

}
