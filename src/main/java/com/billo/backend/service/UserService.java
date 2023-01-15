package com.billo.backend.service;

import com.billo.backend.exceptions.UserDoesntExistException;
import com.billo.backend.model.User;
import com.billo.backend.model.UserLogin;
import com.billo.backend.repository.UserLoginRepository;
import com.billo.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public User getUserByUsername(String username) throws Exception {
        if (username == null) {
            return null;
        }
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UserDoesntExistException();
        }

        try {
            return user;
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

    public List<UserLogin> getAllUsersLogin() throws Exception {
        try {
            return userLoginRepository.findAll();
        } catch (Exception ex) {
            throw new Exception();
        }
    }
}
