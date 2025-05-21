package com.rafademetrio.user_service.dto;

import java.util.Set;

public class UserRequest {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private Set<Long> rolesIds;

    public UserRequest() {
    }

    public UserRequest(Long id, String name, String email, String password, String address, Set<Long> rolesIds) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.rolesIds = rolesIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Long> getRolesIds() {
        return rolesIds;
    }

    public void setRolesIds(Set<Long> rolesIds) {
        this.rolesIds = rolesIds;
    }
}
