package com.cjcStudying.dao;

import com.cjcStudying.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

public interface AdminDao {
    @Select("select aid,username,password " +
            "from admin " +
            "where username = #{username} and password = #{password}")
    Admin findAdminByUsernameAndPassword(@Param("username") String username,
                                         @Param("password") String password)
            throws DataAccessException;
}
