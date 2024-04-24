package com.yjh.MyComputerSpecCheckWebSite.dto.getComputerInfo.response;

import com.yjh.MyComputerSpecCheckWebSite.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;

public record GetComputerInfoResponse(
        @Schema(description = "컴퓨터 사양 수정 성공 여부", example = "true")
        boolean result,
        @Schema(description = "회원 이름", example = "테스트")
        String account,
        @Schema(description = "운영 체제", example = "운영 체제 : windows 10")
        String OSInfo,
        @Schema(description = "프로세서(CPU)", example = "프로세서(CPU) : AMD Ryzen 5 3500X 6-Core Processor")
        String CPUInfo,
        @Schema(description = "그래픽 카드(GPU)", example = "그래픽 카드(GPU) : NVIDIA GeForce GTX 1660 SUPER")
        String GPUInfo,
        @Schema(description = "메모리(RAM)", example = "메모리(RAM) : 15.9 GB")
        String RAMInfo
) {
        public static GetComputerInfoResponse of(boolean result, Member member) {
                return new GetComputerInfoResponse(
                        result,
                        member.getAccount(),
                        member.getOSInfo(),
                        member.getGPUInfo(),
                        member.getCPUInfo(),
                        member.getRAMInfo()
                );
        }
}
