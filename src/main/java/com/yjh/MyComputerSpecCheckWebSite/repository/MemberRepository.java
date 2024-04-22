package com.yjh.MyComputerSpecCheckWebSite.repository;

import com.yjh.MyComputerSpecCheckWebSite.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findByAccount(String account);
}
