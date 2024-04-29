package com.yjh.MyComputerSpecCheckWebSite.service;

import com.yjh.MyComputerSpecCheckWebSite.dto.getMemberComputerInfo.request.GetMemberComputerInfoRequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.getMemberComputerInfo.response.GetMemberComputerInfoResponse;
import com.yjh.MyComputerSpecCheckWebSite.dto.signIn.request.SignInRequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.signIn.response.SignInResponse;
import com.yjh.MyComputerSpecCheckWebSite.dto.signUp.request.SignUpRequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.signUp.response.SignUpResponse;
import com.yjh.MyComputerSpecCheckWebSite.entity.Member;
import com.yjh.MyComputerSpecCheckWebSite.entity.MemberRefreshToken;
import com.yjh.MyComputerSpecCheckWebSite.jwt.TokenProvider;
import com.yjh.MyComputerSpecCheckWebSite.repository.MemberRefreshTokenRepository;
import com.yjh.MyComputerSpecCheckWebSite.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public GetMemberComputerInfoResponse updateSpecInfo(GetMemberComputerInfoRequest request) {
        return memberRepository.findByAccount(request.account())
                .map(member -> {
                    member.updateSpec(request);
                    return GetMemberComputerInfoResponse.of(true, member);
                })
                .orElseThrow(() -> new IllegalArgumentException("일치하는 아이디가 없습니다."));
    }
}
