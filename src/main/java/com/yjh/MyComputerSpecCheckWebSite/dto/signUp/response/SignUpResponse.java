package com.yjh.MyComputerSpecCheckWebSite.dto.signUp.response;

import com.yjh.MyComputerSpecCheckWebSite.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record SignUpResponse(
        @Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b7a-9b9b9b9b9b9b")
        UUID id,
        @Schema(description = "회원 아이디", example = "test")
        String account,
        @Schema(description = "회원 이름", example = "윤준혁")
        String name
) {
    public static SignUpResponse from(Member member) {
        return new SignUpResponse(
                member.getId(),
                member.getAccount(),
                member.getName()
        );
    }
}