package com.ksj.bbs.repository;

import com.ksj.bbs.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleNameContainsIgnoreCase(String roleName);
}
