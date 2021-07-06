package com.cjcStudying.service.imp;

import com.cjcStudying.dao.UserDao;
import com.cjcStudying.domain.ShoppingCart;
import com.cjcStudying.domain.User;
import com.cjcStudying.service.ShoppingCartService;
import com.cjcStudying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ShoppingCartService shoppingCartService;

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

    @Transactional
    public Boolean register(User user) throws DataAccessException{
        Boolean flag = false;
        Boolean flag2 = false;
        try {
            flag = userDao.saveUser(user);
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setUid(user.getUid());
            flag2 = shoppingCartService.addShoppingCart(shoppingCart);
        }catch (DataAccessException e){
            throw e;
        }finally {
            return flag&flag2;
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

    @Override
    public List<User> findAllUser() {
        List<User> userList = userDao.selectAllUser();
        return userList;
    }

    @Override
    public User findUserByUid(String uid) {
        User user = userDao.selectUsernameByUid(uid);
        return user;
    }
}
