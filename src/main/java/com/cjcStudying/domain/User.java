package com.cjcStudying.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

public class User {
    private String username;
    private String password;
    private int uid;
    private String nickname;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;
    private Date updateTime;

    public User() {
        int i = new Random().nextInt();
        int abs = Math.abs(i);
        this.uid = abs;
        Date date = new Date();
        this.updateTime = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uid=" + uid +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", updateTime=" + updateTime +
                '}';
    }

    public void setBirthday(Date birthday) {
//        System.out.println("date here");
        this.birthday = birthday;
    }


    //无用
//    public void setBirthday(String birthday) {
//        System.out.println("primary =" +birthday);
//        Date date = DateUtils.getDate2(birthday);
////        System.out.println("String print"+date);
//        this.birthday =date;
//    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public String getNickname() {
        return nickname;
    }


    public void setNickname(String nickname) {
        String now = nickname;
        try {
             now = new String(nickname.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        System.out.println(now);
        this.nickname = now;
    }

//    public void setNickname(String nickname) {
//        this.nickname = nickname;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
