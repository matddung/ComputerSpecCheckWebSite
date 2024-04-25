package com.yjh.MyComputerSpecCheckWebSite.dto.getMemberComputerInfo.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record GetMemberComputerInfoRequest(
        @Schema(description = "회원 아이디", example = "test")
        String account,
        @Schema(description = "운영 체제", example = "운영 체제 : windows 10")
        String OSInfo,
        @Schema(description = "프로세서(CPU)", example = "AMD Ryzen 5 3500X 6-Core Processor")
        String CPUInfo,
        @Schema(description = "그래픽 카드(GPU)", example = "NVIDIA GeForce GTX 1660 SUPER")
        String GPUInfo,
        @Schema(description = "메모리(RAM)", example = "15.9 GB")
        String RAMInfo
) {
}