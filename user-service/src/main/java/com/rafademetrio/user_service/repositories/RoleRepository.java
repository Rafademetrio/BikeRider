package com.rafademetrio.user_service.repositories;

import com.rafademetrio.user_service.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {



}
