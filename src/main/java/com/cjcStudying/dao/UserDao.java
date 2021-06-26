package com.cjcStudying.dao;

import com.cjcStudying.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {

    @Select("select uid,username,nickname,password,email,birthday,updatetime " +
            "from user " +
            "where username = #{username} and password = #{password}")
    User findUserByUsernameAndPassword(@Param("username") String username,
                                       @Param("password") String password);

    @Insert("insert into user " +
            "(uid,username,nickname,password,email,birthday,updatetime)" +
            "values" +
            "(#{user.uid},#{user.username},#{user.nickname},#{user.password}," +
            "#{user.email},#{user.birthday},#{user.updateTime})")
    Boolean saveUser(@Param("user") User user);

    @Update("update user set "+
            "username = #{user.username},nickname = #{user.nickname}," +
            "password = #{user.password}," +
            "email = #{user.email},birthday = #{user.birthday}," +
            "updatetime = #{user.updateTime} " +
            "where uid = #{user.uid}")
    Boolean updateUser(@Param("user") User user);
}
