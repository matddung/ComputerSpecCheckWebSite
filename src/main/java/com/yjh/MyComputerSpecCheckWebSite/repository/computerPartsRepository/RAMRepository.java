package com.yjh.MyComputerSpecCheckWebSite.repository.computerPartsRepository;

import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.RAM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RAMRepository extends JpaRepository<RAM, Long> {
    Optional<RAM> findByName(String name);
}