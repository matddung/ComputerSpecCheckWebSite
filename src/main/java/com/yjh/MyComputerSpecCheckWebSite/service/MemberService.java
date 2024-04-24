package com.yjh.MyComputerSpecCheckWebSite.service;

import com.yjh.MyComputerSpecCheckWebSite.dto.getComputerInfo.request.GetComputerInfoRequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.getComputerInfo.response.GetComputerInfoResponse;
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
    private final MemberRefreshTokenRepository memberRefreshTokenRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder encoder;

    @Transactional
    public SignUpResponse registMember(SignUpRequest request) {
        Member member = memberRepository.save(Member.from(request, encoder));
        try {
            memberRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
        return SignUpResponse.from(member);
    }

    @Transactional
    public SignInResponse signIn(SignInRequest request) {
        Member member = memberRepository.findByAccount(request.account())
                .filter(it -> encoder.matches(request.password(), it.getPassword()))
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
        String accessToken = tokenProvider.createAccessToken(String.format("%s", member.getId()));
        String refreshToken = tokenProvider.createRefreshToken();
        memberRefreshTokenRepository.findById(member.getId())
                .ifPresentOrElse(
                        it -> it.updateRefreshToken(refreshToken),
                        () -> memberRefreshTokenRepository.save(new MemberRefreshToken(member, refreshToken))
                );
        return new SignInResponse(member.getName(), accessToken, refreshToken);
    }

    @Transactional
    public GetComputerInfoResponse updateSpecInfo(GetComputerInfoRequest request) {
        return memberRepository.findByAccount(request.account())
                .map(member -> {
                    member.updateSpec(request);
                    return GetComputerInfoResponse.of(true, member);
                })
                .orElseThrow(() -> new IllegalArgumentException("일치하는 아이디가 없습니다."));
    }
}
