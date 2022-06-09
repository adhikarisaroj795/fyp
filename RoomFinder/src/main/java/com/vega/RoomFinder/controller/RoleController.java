package com.vega.RoomFinder.controller;

import com.vega.RoomFinder.model.Role;
import com.vega.RoomFinder.model.User;
import com.vega.RoomFinder.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles()
    {
        return  roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable int id)
    {
        return roleService.findById(id);
    }

    @PostMapping
    public Role addRole(@RequestBody Role role)
    {
        return roleService.addRole(role);
    }

    @PutMapping
    public Role updateRole(@RequestBody Role role)
    {
        return roleService.updateRole(role);
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable int id)
    {
        return roleService.deleteRole(id);
    }


}
