package com.sbs.spring1012.controller;

import com.sbs.spring1012.dto.MemberDto;
import com.sbs.spring1012.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  //Rest API에 대한 요청과 응답처리를 위한 어노테이션
@Slf4j
@RequestMapping("/auth") //대표경로 지정
@RequiredArgsConstructor //생성자를 통한 의존성 주입
@CrossOrigin(origins = "http/localhost:3000")
public class AuthController {
    private final AuthService authService;

    //회원가입 여부 확인
    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> memberExists(@PathVariable String email){
        log.info("email : {}",email);
        boolean isTrue = authService.isMember(email);

        return ResponseEntity.ok(!isTrue);
    }

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signup(@RequestBody MemberDto memberDto){
        log.info("memberDto:{}",memberDto);
        boolean isTrue = authService.signup(memberDto);

        return ResponseEntity.ok(isTrue);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody MemberDto memberDto){
        log.info("memberDto:{}",memberDto);
        boolean isTrue = authService.login(memberDto.getEmail(),memberDto.getPwd());

        return ResponseEntity.ok(isTrue);
    }

}
