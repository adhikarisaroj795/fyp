package com.vega.RoomFinder.service;

import com.vega.RoomFinder.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role findById(int id);


    Role addRole(Role role);
    Role updateRole(Role role);

    String deleteRole(int id);

}
