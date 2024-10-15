package com.sbs.spring1012.controller;

import com.sbs.spring1012.dto.MemberDto;
import com.sbs.spring1012.entity.Member;
import com.sbs.spring1012.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class MemberController {
    private final MemberService memberService;

    //회원 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<MemberDto>> memberList(){
        List<MemberDto> list = memberService.getMemberList();
        return ResponseEntity.ok(list);
    }

    //회원 상세 조회
//    @GetMapping("/detail/{email}")
//    public ResponseEntity<Boolean> memberDetail(@PathVariable String email){
//        MemberDto memberDto = memberService.getMemberDetail(email);
//    }
}
