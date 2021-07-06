package com.cjcStudying.service.imp;

import com.cjcStudying.dao.AdminDao;
import com.cjcStudying.domain.Admin;
import com.cjcStudying.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public Admin login(String username, String password) throws DataAccessException {
        Admin admin = adminDao.findAdminByUsernameAndPassword(username, password);
        return  admin;
    }

    @Transactional
    @Override
    public Boolean register(Admin admin) {
        Admin admin1 = adminDao.selectAdminByUsername(admin.getUsername());
        if(admin1==null) {
            Boolean flag = adminDao.insertAdmin(admin);
            return flag;
        }
        return false;
    }

    @Override
    public List<Admin> findAllAdmin() {
        List<Admin> admins = adminDao.selectAllAdmin();
        return admins;
    }

    @Override
    public Boolean modifyAdminPassword(Admin admin) {
        Boolean flag = adminDao.updateAdminPassword(admin);
        return flag;
    }
}
