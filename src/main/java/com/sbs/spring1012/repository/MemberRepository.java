package com.sbs.spring1012.repository;

import com.sbs.spring1012.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Member> findByEmailAndPwd(String email,String pwd);

}
