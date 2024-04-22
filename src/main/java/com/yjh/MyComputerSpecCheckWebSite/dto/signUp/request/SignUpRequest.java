package com.yjh.MyComputerSpecCheckWebSite.dto.signUp.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record SignUpRequest(
        @Schema(description = "회원 아이디", example = "test")
        String account,
        @Schema(description = "회원 비밀번호", example = "test")
        String password,
        @Schema(description = "회원 이름", example = "윤준혁")
        String name
) {
}