package com.yjh.MyComputerSpecCheckWebSite.entity.computerParts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class CPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String coreCount;
    private String coreClock;
    private String boostClock;
    private String TDP;
    private String graphics;
    private String SMT;
}