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
public class RAM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String speed;
    private String modules;
    private String pricePerGB;
    private String firstWordLatency;
    private String casLatency;
}