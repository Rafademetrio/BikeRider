package com.rafademetrio.user_service.service;


import com.rafademetrio.user_service.dto.UserRequest;
import com.rafademetrio.user_service.dto.UserResponse;
import com.rafademetrio.user_service.entities.Role;
import com.rafademetrio.user_service.entities.User;
import com.rafademetrio.user_service.repositories.RoleRepository;
import com.rafademetrio.user_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserRequest userRequest){
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        Set<Role> roles = userRequest.getRolesIds().stream()
                .map(roleRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        user.setRoles(roles);


        User savedUser = userRepository.save(user);
        return mapToUserResponse(savedUser);
    }



    private UserResponse mapToUserResponse(User user) {

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setAddress(user.getAddress());

        Set<String> roleNames = user.getRoles().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toSet());

        response.setRoles(roleNames);

        return response;
    }

    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> responses = this.userRepository.findAll().stream().map(user-> mapToUserResponse(user)).collect(Collectors.toList());


        return ResponseEntity.ok(responses);
    }
}