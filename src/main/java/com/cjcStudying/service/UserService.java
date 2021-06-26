package com.cjcStudying.service;

import com.cjcStudying.domain.User;

public interface UserService {

    User login(String username, String password);

    Boolean regist(User user);

    Boolean updateUser(User user);
}
