package com.sbs.spring1012.repository;

import com.sbs.spring1012.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    boolean existsByEmail(String email);
    Optional<Member> findByAlias(String alias);
    Optional<Member> findByEmailAndPwd(String email, String password);
    Optional<Member> findByEmail(String email);

}
