package com.yjh.MyComputerSpecCheckWebSite.dto.computerParts.ram.response;

import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.RAM;

public record ComputerPartsRAMResponse(
        String name,
        Double speed
) {
    public static ComputerPartsRAMResponse from(RAM ram) {
        return new ComputerPartsRAMResponse(
                ram.getName(),
                ram.getSpeed()
        );
    }
}
