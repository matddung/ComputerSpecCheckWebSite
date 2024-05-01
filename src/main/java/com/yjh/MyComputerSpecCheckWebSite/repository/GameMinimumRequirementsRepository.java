package com.yjh.MyComputerSpecCheckWebSite.repository;

import com.yjh.MyComputerSpecCheckWebSite.entity.GameMinimumRequirements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameMinimumRequirementsRepository extends JpaRepository<GameMinimumRequirements, Long> {
    Optional<GameMinimumRequirements> findByName(String name);
}
