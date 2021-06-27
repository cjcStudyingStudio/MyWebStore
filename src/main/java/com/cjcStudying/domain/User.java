package com.cjcStudying.domain;

import com.cjcStudying.utls.DateUtils;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private int uid;
    private String nickname;
    private String email;
    private Date birthday;
    private Date updateTime;

    public User() {
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
        this.birthday = birthday;
    }

    public void setBirthday(String birthday) {
        Date date = DateUtils.getDate(birthday);
//        System.out.println("String print"+date);
        this.birthday =date;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdateTime(String updateTime) {
        Date date = DateUtils.getDate(updateTime);
//        System.out.println("String print"+date);
        this.updateTime = date;
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

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
