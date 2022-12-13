package com.billo.backend.repository;

import com.billo.backend.model.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,String> {

     User findUserById(String id);
     User findUserByUsername(String username);

     List<User> findAll();

     //Elasticsearch Java Library
     @Query("{\"match\": {\"username\": {\"query\": \"?0\"}},{\"password\": {\"query\": \"?1\"}}}")
     User findUserByUsernameAndPassword(String username, String password);
}
