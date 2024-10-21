package com.sbs.spring1012.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
//킅라이언트에 토큰을 보내기위한 Dto
public class TokenDto {
    private String grantType; //Jwt에 대한 인증 타입
    private String accessToken;
    private Long tokenExpiresIn;
}
