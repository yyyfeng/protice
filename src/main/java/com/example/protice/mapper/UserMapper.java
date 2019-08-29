package com.example.protice.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user(userName,userPass,userAge,userSex,userMobile) values(#{userName},#{userPass},#{userAge},#{userSex},#{userMobile} )")
    int insertUser(@Param("userName") String  userName, @Param("userPass") String  userPass,@Param("userAge") int  userAge, @Param("userSex") String userSex,
                   @Param("userMobile") String userMobile);

}
