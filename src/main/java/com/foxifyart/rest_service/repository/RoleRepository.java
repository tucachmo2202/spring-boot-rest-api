package com.foxifyart.rest_service.repository;

import com.foxifyart.rest_service.entity.Permission;
import com.foxifyart.rest_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
