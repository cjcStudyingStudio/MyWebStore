package com.cjcStudying.service;

import com.cjcStudying.domain.Admin;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface AdminService {
    Admin login(String username, String password) throws DataAccessException;

    Boolean register(Admin admin);

    List<Admin> findAllAdmin();

    Boolean modifyAdminPassword(Admin admin);
}
