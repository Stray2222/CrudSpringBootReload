package com.crud.bim.service;

import com.crud.bim.exception.PaymentRequiredException;
import com.crud.bim.models.User;
import com.crud.bim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        if (!userRepository.findUserByEmail(user.getEmail()).isEmpty()
                 && userRepository.findUserById(user.getId()).isEmpty()) {
            throw new PaymentRequiredException("User already exist");
        } else {
            userRepository.save(user);
        }
    }


    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
