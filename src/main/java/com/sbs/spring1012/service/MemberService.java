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

    public List<MemberDto> getMemberList(){
        List<Member> members = memberRepository.findAll();
        List<MemberDto> memberDtos = new ArrayList<>();

        for(Member member : members){
            MemberDto memberDto = covertDto(member);
            memberDtos.add(memberDto);
        }

        return memberDtos;
    }
    
    //회원검색
    public MemberResDto userSearch(String alias){
        Optional<Member> member = memberRepository.findByAlias(alias);
        //member에 값이 있다면 dto로 변환하여 방환 아니라면 null반환
        return member.map(MemberResDto::of).orElse(null);
    }

    //회원 상세정보
    public MemberDto getMemberDetail(String email){
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("해당 회원이 존재하지않습니다."));
        return covertDto(member);
    }

    //회원수정
    public boolean modifyMember(MemberDto memberDto){
        try {
            Member member = memberRepository.findByEmail(memberDto.getEmail())
                    .orElseThrow(()-> new RuntimeException("해당 회원이 존재하지않습니다."));

            // 수정이 가능한 프로퍼티들만 set하여 save할 경우 update 로 들어간다.
            member.setName(memberDto.getName());
            member.setImage(memberDto.getImage());
            memberRepository.save(member);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //회원삭제
    public boolean deleteMember(String email){
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("해당 회원이 존재하지않습니다."));

    }
    private MemberDto covertDto(Member member){
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail(member.getEmail());
        memberDto.setName(member.getName());
        memberDto.setImage(member.getImage());
        memberDto.setPwd(member.getPwd());
        memberDto.setRegDate(member.getRegDate());
        return memberDto;
    }
}
