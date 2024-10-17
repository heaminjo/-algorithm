package com.sbs.spring1012.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString(exclude = "pwd") // pwd는 제외하고 출력
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member")
    private Long member_seq;

    //이메일
    @Column(name = "email",nullable = false,unique = true)
    private String email;

    //패스워드
    @Column(name = "pwd",nullable = false)
    private String pwd;

    //별명
    @Column(name = "alias",nullable = false,unique = true,length = 8)
    private String alias;
    //주소
    @Column(name = "address",nullable = false)
    private String address;

    //관심태그
    @Convert(converter = StringListConverter.class)
    private List<String> tag;

    //팔로워 수
    private int follower;

    //팔로윙 수
    private int followee;

    @Enumerated(EnumType.STRING)
    private Authority authority;
    
    @Builder
    public Member(String email,String pwd,String alias,String address,
                  List<String> tag, int follower,int followee,
                  Authority authority){
        this.email = email;
        this.pwd = pwd;
        this.alias = alias;
        this.address = address;
        this.tag = tag;
        this.follower = follower;
        this.followee = followee;
        this.authority = authority;
    }
}
