package com.sbs.spring1012.repository;

import com.sbs.spring1012.entity.Member;
import com.sbs.spring1012.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    boolean existsByMember(Member member);
    void deleteByMember(Member member);
}
