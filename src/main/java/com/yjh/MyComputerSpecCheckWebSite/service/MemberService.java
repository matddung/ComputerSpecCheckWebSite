package com.yjh.MyComputerSpecCheckWebSite.service;

import com.yjh.MyComputerSpecCheckWebSite.dto.getMemberComputerInfo.request.GetMemberComputerInfoRequest;
import com.yjh.MyComputerSpecCheckWebSite.dto.getMemberComputerInfo.response.GetMemberComputerInfoResponse;
import com.yjh.MyComputerSpecCheckWebSite.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public GetMemberComputerInfoResponse updateSpecInfo(GetMemberComputerInfoRequest request) {
        return memberRepository.findByAccount(request.account())
                .map(member -> {
                    member.updateSpec(request);
                    return GetMemberComputerInfoResponse.of(true, member);
                })
                .orElseThrow(() -> new IllegalArgumentException("일치하는 아이디가 없습니다."));
    }
}
