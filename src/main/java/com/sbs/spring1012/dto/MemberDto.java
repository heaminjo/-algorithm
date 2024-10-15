package com.sbs.spring1012.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class MemberDto {
    private String pwd;
    private String email;
    private String name;
    private String image;
    private LocalDateTime regDate;
}
