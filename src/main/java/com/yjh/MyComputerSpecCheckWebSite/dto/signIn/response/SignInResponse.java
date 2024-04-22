package com.yjh.MyComputerSpecCheckWebSite.dto.signIn.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record SignInResponse(
        @Schema(description = "회원 이름", example = "테스트")
        String name,
        String token,
        String refreshToken
) {
}

