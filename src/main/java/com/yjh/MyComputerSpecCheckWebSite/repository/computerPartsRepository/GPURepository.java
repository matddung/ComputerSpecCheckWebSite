package com.yjh.MyComputerSpecCheckWebSite.repository;

import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.GPU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GPURepository extends JpaRepository<GPU, Long> {
    List<GPU> findByName(String name);
}
