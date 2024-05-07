package com.yjh.MyComputerSpecCheckWebSite.controller;

import com.yjh.MyComputerSpecCheckWebSite.dto.ApiResponse;
import com.yjh.MyComputerSpecCheckWebSite.dto.gameMinimumRequirements.request.GameMinimumRequirementsRequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.signIn.request.SignInRequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.signUp.request.SignUpRequest;
import com.yjh.MyComputerSpecCheckWebSite.service.CommonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class CommonController {
    private final CommonService commonService;

    @Operation(summary = "회원 가입")
    @PostMapping("/signUp")
    public ApiResponse signUp(@RequestBody SignUpRequest request) {
        return ApiResponse.success(commonService.registMember(request));
    }

    @Operation(summary = "로그인")
    @PostMapping("/signIn")
    public ApiResponse signIn(@RequestBody SignInRequest request) {
        return ApiResponse.success(commonService.signIn(request));
    }

    @Operation(summary = "게임 이름으로 게임 최저 스펙 불러오기")
    @PostMapping("/getGameSpecFromName")
    public ApiResponse getGameSpecFromName(@RequestBody GameMinimumRequirementsRequest request) {
        return ApiResponse.success(commonService.getGameSpecFromName(request));
    }
}
