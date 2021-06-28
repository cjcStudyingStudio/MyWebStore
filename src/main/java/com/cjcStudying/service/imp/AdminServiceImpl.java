package com.cjcStudying.service.imp;

import com.cjcStudying.dao.AdminDao;
import com.cjcStudying.domain.Admin;
import com.cjcStudying.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public Admin login(String username, String password) throws DataAccessException {
        Admin admin = adminDao.findAdminByUsernameAndPassword(username, password);
        return  admin;
    }
}
