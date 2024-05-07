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
public class GPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String name;
    private int releaseYear;
    private int memSize;
    private int memBusWidth;
    private int gpuClock;
    private int memClock;
    private int unifiedShader;
    private int tmu;
    private int rop;
    private String memType;
}