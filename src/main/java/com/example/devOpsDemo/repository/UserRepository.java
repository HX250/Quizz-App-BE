package main.java.com.example.devOpsDemo.repository;


import main.java.com.example.devOpsDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserId(Integer userId);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
