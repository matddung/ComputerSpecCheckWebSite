package com.yjh.MyComputerSpecCheckWebSite;

import com.yjh.MyComputerSpecCheckWebSite.entity.Member;
import com.yjh.MyComputerSpecCheckWebSite.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataInitializer implements ApplicationRunner {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(ApplicationArguments args) {
        memberRepository.save(Member.builder()
                .account("test1")
                .password(encoder.encode("test1"))
                .name("test1")
                .build());

        memberRepository.save(Member.builder()
                .account("test2")
                .password(encoder.encode("test2"))
                .name("test2")
                .build());

        memberRepository.save(Member.builder()
                .account("test3")
                .password(encoder.encode("test3"))
                .name("test3")
                .build());
    }
}