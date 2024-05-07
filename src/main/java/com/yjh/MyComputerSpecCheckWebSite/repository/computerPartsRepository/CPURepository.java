package com.yjh.MyComputerSpecCheckWebSite.repository.computerPartsRepository;

import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.CPU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CPURepository extends JpaRepository<CPU, Long> {
    Optional<CPU> findByName(String name);
}
