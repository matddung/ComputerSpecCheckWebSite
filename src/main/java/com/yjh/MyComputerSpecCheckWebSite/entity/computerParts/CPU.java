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
    private int tdp;
    private String date;
    private String category;
    private int speed;
    private int turbo;
    private int cores;
}