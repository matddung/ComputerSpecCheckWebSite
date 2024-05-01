package com.yjh.MyComputerSpecCheckWebSite.dto.gameMinimumRequirements.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record GameMinimumRequirementsRequest(
        @Schema(description = "게임 이름", example = "Hogwarts Legacy")
        String name
) {
}
