package com.vega.RoomFinder.service.impl;

import com.vega.RoomFinder.model.Role;
import com.vega.RoomFinder.repository.RoleRepository;
import com.vega.RoomFinder.repository.UserRepository;
import com.vega.RoomFinder.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        roleRepository.findById(role.getId()).orElseThrow(() -> new RuntimeException("role mot found"));
        return roleRepository.save(role);
    }

    @Override
    public String deleteRole(int id) {
        roleRepository.findById(id).orElseThrow(() -> new RuntimeException("role mot found"));
        roleRepository.deleteById(id);
        return "role deleted sucessfully";
    }
}
