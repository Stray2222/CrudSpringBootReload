package com.crud.bim.Service;


import com.crud.bim.models.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUserById(int id);

}
