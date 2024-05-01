package com.yjh.MyComputerSpecCheckWebSite.repository.computerPartsRepository;

import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.CPU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CPURepository extends JpaRepository<CPU, Long> {
    List<CPU> findByName(String name);
}
