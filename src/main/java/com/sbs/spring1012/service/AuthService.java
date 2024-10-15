package com.sbs.spring1012.service;

import com.sbs.spring1012.dto.MemberDto;
import com.sbs.spring1012.entity.Member;
import com.sbs.spring1012.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

//회원가입/로그인 서비스
@Slf4j //로그 메시지 출력
@Service  //스프링 빈 컨테이너에 등록
@RequiredArgsConstructor //생성자를 통해서 의존성 주입을 받기위한 어노테이션
@Transactional
public class AuthService {
    private final MemberRepository memberRepository; //의존성 주입

    //회원가입 여부 확인
    //이메일이 이미 등록되어있다면 가입 불가능
    public boolean isMember(String email){
        return memberRepository.existsByEmail(email);
    }

    //회원가입 성공/실패
    public boolean signup(MemberDto memberDto){

        try {
            Member member = covertDtoToEntity(memberDto);
            memberRepository.save(member);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean login(String email,String pwd){
        Optional<Member> member = memberRepository.findByEmailAndPwd(email,pwd);
        return member.isPresent();
    }

    //회원 dto -> Entity로 변환
    public Member covertDtoToEntity(MemberDto memberDto){
        Member member = new Member();
        member.setPwd(memberDto.getPwd());
        member.setEmail(memberDto.getEmail());
        member.setImage(memberDto.getImage());
        return member;
    }
}
