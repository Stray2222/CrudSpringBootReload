package com.crud.bim.repository;


import com.crud.bim.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByEmail(String email);
    List<User>findUserById(long id);
}
