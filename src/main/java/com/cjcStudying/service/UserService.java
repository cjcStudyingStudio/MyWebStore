package com.cjcStudying.service;

import com.cjcStudying.domain.User;

import java.util.List;

public interface UserService {

    User login(String username, String password);

    Boolean register(User user);

    Boolean updateUser(User user);

    List<User> findAllUser();
}
