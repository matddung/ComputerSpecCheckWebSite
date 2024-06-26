package com.yjh.MyComputerSpecCheckWebSite.entity;

import com.yjh.MyComputerSpecCheckWebSite.common.MemberType;
import com.yjh.MyComputerSpecCheckWebSite.dto.getMemberComputerInfo.request.GetMemberComputerInfoRequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.signUp.request.SignUpRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String account;
    private String password;
    private String name;
    private MemberType type;
    private String OSInfo;
    private String GPUInfo;
    private String CPUInfo;
    private String RAMInfo;

    public static Member from(SignUpRequest request, PasswordEncoder encoder) {
        return Member.builder()
                .account(request.account())
                .password(encoder.encode(request.password()))
                .name(request.name())
                .type(MemberType.USER)
                .build();
    }

    public void updateSpec(GetMemberComputerInfoRequest request) {
        this.OSInfo = request.OSInfo();
        this.GPUInfo = request.GPUInfo();
        this.CPUInfo = request.CPUInfo();
        this.RAMInfo = request.RAMInfo();
    }

    @Builder
    private Member(String account, String password, String name, MemberType type, String OSInfo, String GPUInfo, String CPUInfo, String RAMInfo, String diskInfo) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.type = type;
        this.OSInfo = OSInfo;
        this.GPUInfo = GPUInfo;
        this.CPUInfo = CPUInfo;
        this.RAMInfo = RAMInfo;
    }
}
