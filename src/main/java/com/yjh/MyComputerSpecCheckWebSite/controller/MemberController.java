package com.yjh.MyComputerSpecCheckWebSite.controller;

import com.yjh.MyComputerSpecCheckWebSite.dto.ApiResponse;
import com.yjh.MyComputerSpecCheckWebSite.dto.getMemberComputerInfo.request.GetMemberComputerInfoRequest;
import com.yjh.MyComputerSpecCheckWebSite.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "회원 컴퓨터 부품 정보 업데이트")
    @PostMapping("/updateSpec")
    public ApiResponse updateSpecInfo(@RequestBody GetMemberComputerInfoRequest request) {
        return ApiResponse.success(memberService.updateSpecInfo(request));
    }
}
