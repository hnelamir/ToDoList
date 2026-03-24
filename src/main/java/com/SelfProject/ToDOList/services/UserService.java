package com.SelfProject.ToDOList.services;

import com.SelfProject.ToDOList.model.User;
import com.SelfProject.ToDOList.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder ;
    private JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public String  login(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user!= null&&passwordEncoder.matches(password,user.getPassword())){
            return jwtService.generateToken(user);
        }
        return null;
    }
}
