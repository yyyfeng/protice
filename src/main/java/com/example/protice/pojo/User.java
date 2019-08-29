package com.example.protice.pojo;

import lombok.Data;

@Data
public class User {

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
