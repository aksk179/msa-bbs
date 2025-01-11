package com.ksj.bbs.service;

import com.ksj.bbs.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> findById(Long id);

    List<Role> findAll();

    Role save(Role role);

    Role findByRoleNameContainsIgnoreCase(String roleName);

    void deleteById(Long id);
}
