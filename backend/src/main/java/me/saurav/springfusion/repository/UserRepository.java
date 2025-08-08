package me.saurav.springfusion.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.saurav.springfusion.modal.User;

public interface UserRepository extends MongoRepository<User, String> {


    Optional<User> findByEmailIgnoreCase(String email);

    Optional<User> findByUsernameIgnoreCase(String username);

}
