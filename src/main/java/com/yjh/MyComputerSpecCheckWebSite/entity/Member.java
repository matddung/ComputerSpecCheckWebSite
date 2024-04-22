package com.yjh.MyComputerSpecCheckWebSite.entity;

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

    public static Member from(SignUpRequest request, PasswordEncoder encoder) {
        return Member.builder()
                .account(request.account())
                .password(encoder.encode(request.password()))
                .name(request.name())
                .build();
    }

    @Builder
    private Member(String account, String password, String name) {
        this.account = account;
        this.password = password;
        this.name = name;
    }
}
