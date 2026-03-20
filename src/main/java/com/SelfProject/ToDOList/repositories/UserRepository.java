package com.SelfProject.ToDOList.repositories;

import com.SelfProject.ToDOList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserName(String userName);

    public User findByEmail(String email);

}
