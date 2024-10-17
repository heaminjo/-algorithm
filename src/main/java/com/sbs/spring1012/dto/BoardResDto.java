package com.sbs.spring1012.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardResDto {
    private String title;
    private String content;
    private String boardType;
    private List<String> tag;
    private int views;
    private int greatNum;
    private LocalDateTime regDate;
}
