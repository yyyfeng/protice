package com.example.protice.pojo;

import lombok.Data;

@Data
public class User {

    private int userId;  //此处ID为后面需求加入，不做其他作用
    private String userName;
    private String userPass;
    private String userSex;
    private int  userAge;
    private String userMobile;

    public User(String userName, String userPass, String userSex, int userAge, String userMobile) {
        this.userName = userName;
        this.userPass = userPass;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userMobile = userMobile;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userMobile='" + userMobile + '\'' +
                '}';
    }
}
