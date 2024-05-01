package com.yjh.MyComputerSpecCheckWebSite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class GameMinimumRequirements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String memory;
    private String GPU;
    private String CPU;
    private String fileSize;
    private String system;
}
