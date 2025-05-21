package com.rafademetrio.user_service.config;

import com.rafademetrio.user_service.entities.User;
import com.rafademetrio.user_service.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataFeeder {
    private final UserRepository repository;

    public DataFeeder(UserRepository repository){
        this.repository = repository;
    }

    @PostConstruct
    public void loadData(){
        repository.save(new User("Rafael", "rafael@gmail.com", "123456", "rua lalala, 123"));
        repository.save(new User("Rodrigo", "rodrigo@gmail.com", "123456", "rua lalala, 123"));
    }
}
