package com.yjh.MyComputerSpecCheckWebSite.dto.signIn.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record SignInRequest(
        @Schema(description = "회원 아이디", example = "test")
        String account,
        @Schema(description = "회원 비밀번호", example = "test")
        String password
) {
}