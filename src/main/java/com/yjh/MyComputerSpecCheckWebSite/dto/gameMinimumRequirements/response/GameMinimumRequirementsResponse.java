package com.yjh.MyComputerSpecCheckWebSite.dto.gameMinimumRequirements.response;

import com.yjh.MyComputerSpecCheckWebSite.entity.GameMinimumRequirements;
import io.swagger.v3.oas.annotations.media.Schema;

public record GameMinimumRequirementsResponse(
        @Schema(description = "게임 이름", example = "Hogwarts Legacy")
        String name,
        @Schema(description = "최소 RAM", example = "6 GB")
        String memory,
        @Schema(description = "최소 GPU", example = "NVIDIA GeForce GTX 980")
        String GPU,
        @Schema(description = "최소 RAM", example = "Intel Core i5-6600")
        String CPU,
        @Schema(description = "파일 크기(필요 여유 공간)", example = "30 GB")
        String fileSize,
        @Schema(description = "최소 운영 체제", example = "Windows 10")
        String system
) {
        public static GameMinimumRequirementsResponse from(GameMinimumRequirements gameMinimumRequirements) {
                return new GameMinimumRequirementsResponse(
                        gameMinimumRequirements.getName(),
                        gameMinimumRequirements.getMemory(),
                        gameMinimumRequirements.getGPU(),
                        gameMinimumRequirements.getCPU(),
                        gameMinimumRequirements.getFileSize(),
                        gameMinimumRequirements.getSystem()
                );
        }
}
