package com.ms.model;

public class User {

    private Integer u_id;

    private String username;
    private String password;

    public  User(String username,String password){
        this.username = username;
        this.password = password;
    }
    public User(){
        this.username = "xxxx";
        this.password = "0000";
    }
}

