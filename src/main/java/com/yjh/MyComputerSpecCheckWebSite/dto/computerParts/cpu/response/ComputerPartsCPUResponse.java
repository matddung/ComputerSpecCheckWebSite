package com.yjh.MyComputerSpecCheckWebSite.dto.computerParts.cpu.response;

import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.CPU;

public record ComputerPartsCPUResponse(
    String name,
    int tdp,
    String date,
    String category,
    int speed,
    int turbo,
    int cores
) {
    public static ComputerPartsCPUResponse from(CPU cpu) {
        return new ComputerPartsCPUResponse(
                cpu.getName(),
                cpu.getTdp(),
                cpu.getDate(),
                cpu.getCategory(),
                cpu.getSpeed(),
                cpu.getTurbo(),
                cpu.getCores()
        );
    }
}
