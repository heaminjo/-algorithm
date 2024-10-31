package com.sbs.spring1012.service;

import com.sbs.spring1012.dto.MemberDto;
import com.sbs.spring1012.entity.Member;
import com.sbs.spring1012.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j //로그 메시지 출력
@Service  //스프링 빈 컨테이너에 등록
@RequiredArgsConstructor //생성자를 통해서 의존성 주입을 받기위한 어노테이션

public class MemberService {
    private final MemberRepository memberRepository;
    
    //회원검색
    public MemberResDto userSearch(String alias){
        Optional<Member> member = memberRepository.findByAlias(alias);
        //member에 값이 있다면 dto로 변환하여 방환 아니라면 null반환
        return member.map(MemberResDto::of).orElse(null);
    }

    //회원 상세조회
    public MemberResDto getMemberDetail(Long id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new RuntimeException("해당 회원이 존재하지 않습니다."));
        return MemberResDto.of(member);
    }
}
