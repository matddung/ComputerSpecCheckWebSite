package com.yjh.MyComputerSpecCheckWebSite.dto.computerParts.gpu.response;

import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.GPU;

public record ComputerPartsGPUResponse(
    String manufacturer,
    String name,
    int releaseYear,
    int memSize,
    int memBusWidth,
    int gpuClock,
    int memClock,
    int unifiedShader,
    int tmu,
    int rop,
    String memType
) {
    public static ComputerPartsGPUResponse from(GPU gpu) {
        return new ComputerPartsGPUResponse(
            gpu.getManufacturer(),
            gpu.getName(),
            gpu.getReleaseYear(),
            gpu.getMemSize(),
            gpu.getMemBusWidth(),
            gpu.getGpuClock(),
            gpu.getMemClock(),
            gpu.getUnifiedShader(),
            gpu.getTmu(),
            gpu.getRop(),
            gpu.getMemType()
        );
    }
}
