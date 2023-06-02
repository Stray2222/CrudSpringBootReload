package com.crud.bim.service;


import com.crud.bim.models.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user) throws Exception;

    void deleteUserById(Long id);
}
