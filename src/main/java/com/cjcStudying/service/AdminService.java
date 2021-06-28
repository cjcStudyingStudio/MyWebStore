package com.cjcStudying.service;

import com.cjcStudying.domain.Admin;
import org.springframework.dao.DataAccessException;

public interface AdminService {
    Admin login(String username, String password) throws DataAccessException;
}
