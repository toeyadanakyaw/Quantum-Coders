package com.announce.AcknowledgeHub_SpringBoot.repository;

import com.announce.AcknowledgeHub_SpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);  // Updated to match the property name in UserEntity

}
