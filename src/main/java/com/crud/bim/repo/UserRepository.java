package com.crud.bim.repo;


import com.crud.bim.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Signature;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUserByEmail(String email);
}
