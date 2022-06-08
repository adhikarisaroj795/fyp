package com.vega.RoomFinder.repository;


import com.vega.RoomFinder.model.ResourceFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceFileRepository extends JpaRepository<ResourceFile, Integer> {
}
