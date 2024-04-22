package com.yjh.MyComputerSpecCheckWebSite.controller;

import com.yjh.MyComputerSpecCheckWebSite.dto.ApiResponse;
import com.yjh.MyComputerSpecCheckWebSite.dto.signIn.request.SignInRequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.signUp.request.SignUpRequest;
import com.yjh.MyComputerSpecCheckWebSite.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "회원 가입")
    @PostMapping("/signUp")
    public ApiResponse signUp(@RequestBody SignUpRequest request) {
        return ApiResponse.success(memberService.registMember(request));
    }

    @Operation(summary = "로그인")
    @PostMapping("/signIn")
    public ApiResponse signIn(@RequestBody SignInRequest request) {
        return ApiResponse.success(memberService.signIn(request));
    }
}
