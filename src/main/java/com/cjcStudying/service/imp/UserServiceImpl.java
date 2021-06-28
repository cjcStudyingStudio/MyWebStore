package com.cjcStudying.service.imp;

import com.cjcStudying.dao.UserDao;
import com.cjcStudying.domain.User;
import com.cjcStudying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User login(String username, String password) throws DataAccessException{
        User user = null;
        try {
            user = userDao.findUserByUsernameAndPassword(username, password);
        }catch (DataAccessException e){
            throw e;
        }finally {
            return user;
        }
    }

    public Boolean register(User user) throws DataAccessException{
        Boolean flag = false;
        try {
                flag = userDao.saveUser(user);
        }catch (DataAccessException e){
            throw e;
        }finally {
            return flag;
        }
    }

    public Boolean updateUser(User user) throws DataAccessException{
        Boolean flag = false;
        try {
                flag = userDao.updateUser(user);
        }catch (DataAccessException e){
            throw e;
        }finally {
            return flag;
        }
    }
}
