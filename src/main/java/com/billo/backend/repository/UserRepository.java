package com.billo.backend.repository;

import com.billo.backend.model.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,String> {
     User findUserById(String id);
     User findUserByUsername(String username);
     User findUserByEmail(String email);
     List<User> findAll();
     User findByUsernameAndPassword(String username, String password);

     Boolean existsByUsername(String username);
     Boolean existsByEmail(String email);

     Optional<User> findByUsername(String username);
}
