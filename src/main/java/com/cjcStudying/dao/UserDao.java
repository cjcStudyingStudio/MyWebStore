package com.cjcStudying.dao;

import com.cjcStudying.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserDao {

    @Select("select uid,username,nickname,password,email,birthday,updatetime " +
            "from user " +
            "where username = #{username} and password = #{password}")
    User findUserByUsernameAndPassword(@Param("username") String username,
                                       @Param("password") String password)
                                        throws DataAccessException;

    @Insert("insert into user " +
            "(uid,username,nickname,password,email,birthday,updatetime)" +
            "values" +
            "(#{user.uid},#{user.username},#{user.nickname},#{user.password}," +
            "#{user.email},#{user.birthday},#{user.updateTime})")
    Boolean saveUser(@Param("user") User user) throws DataAccessException;


    /**
     * @param user 根据uid（唯一） 来修改
     * @return  插入失败时候是否返回False
     */
    @Update("update user set "+
            "nickname = #{user.nickname}," +
            "password = #{user.password}," +
            "email = #{user.email}," +
            "birthday = #{user.birthday}" +
            "where uid = #{user.uid}")
    Boolean updateUser(@Param("user") User user) throws DataAccessException;

    @Select("select uid,username,nickname,password,email,birthday,updatetime " +
            "from user")
    List<User> selectAllUser();

    @Select("select username " +
            "from user where uid = #{uid}")
    User selectUsernameByUid(@Param("uid") String uid);

    @Select("select uid " +
            "from user where username = #{username}")
    User selectUserByUsername(@Param("username")String username);
}
