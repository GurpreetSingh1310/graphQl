package com.graphql.graphql.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.graphql.graphql.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email); // Custom query method
}
