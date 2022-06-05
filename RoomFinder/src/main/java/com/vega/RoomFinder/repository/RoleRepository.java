package com.vega.RoomFinder.repository;

import com.vega.RoomFinder.model.Role;
import com.vega.RoomFinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
