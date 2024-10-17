package com.sbs.spring1012.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardReqDto {
    private String title;
    private String content;
    private String boardType;
    private List<String> tag;
}
