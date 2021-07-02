package com.cjcStudying.dao;

import com.cjcStudying.domain.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface AdminDao {
    @Select("select aid,username,password " +
            "from admin " +
            "where username = #{username} and password = #{password}")
    Admin findAdminByUsernameAndPassword(@Param("username") String username,
                                         @Param("password") String password)
            throws DataAccessException;

    @Insert("insert into admin " +
            "(aid,username,password) " +
            "values " +
            "(#{admin.aid},#{admin.username},#{admin.password})")
    Boolean insertAdmin(@Param("admin") Admin admin);

    @Select("select aid,username,password from admin")
    List<Admin> selectAllAdmin();

    @Update("update admin " +
            "set password = #{admin.password} " +
            "where username = #{admin.username}")
    Boolean updateAdminPassword(@Param("admin") Admin admin);
}
