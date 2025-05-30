package com.rafademetrio.user_service.repositories;

import com.rafademetrio.user_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);


}
