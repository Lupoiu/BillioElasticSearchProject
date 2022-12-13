package com.billo.backend.service;

import com.billo.backend.model.User;
import com.billo.backend.repository.UserRepository;
import com.billo.backend.security.UserRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerNewUser(UserRequestVo userRequestVo) {
        User user = User.builder().username(userRequestVo.getUsername()).password(userRequestVo.getPassword()).email(userRequestVo.getEmail()).build();

        userRepository.save(user);
    }

    public UserRequestVo getUserById(String id) throws Exception {
        User user;
        if (id == null) {
            return null;
        }

        try {
            user = userRepository.findUserById(id);
        }  catch (Exception ex) {
            throw new Exception();
        }

        return UserRequestVo.builder().username(user.getUsername()).email(user.getEmail()).build();
    }

    public User getUserByUsername(String username) throws Exception {
        if (username == null) {
            return null;
        }

        try {
            return userRepository.findUserByUsername(username);
        } catch (Exception ex) {
            throw new Exception();
        }
    }

    public List<User> getAllUsers() throws Exception {
        try {
            return userRepository.findAll();
        } catch (Exception ex) {
            throw new Exception();
        }
    }
}
