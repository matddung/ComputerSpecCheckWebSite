package com.yjh.MyComputerSpecCheckWebSite.repository.computerPartsRepository;

import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.GPU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GPURepository extends JpaRepository<GPU, Long> {
    Optional<GPU> findByName(String name);
}
