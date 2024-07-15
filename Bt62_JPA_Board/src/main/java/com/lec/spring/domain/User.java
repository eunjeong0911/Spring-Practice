package com.lec.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;  // 회원 아이디
    @JsonIgnore
    private String password;  // 회원 비밀번호

    @ToString.Exclude
    @JsonIgnore
    private String re_password;  // 비밀번호 확인 입력

    private String name;    // 회원 이름
    private String email;   // 이메일

    @JsonIgnore
    private LocalDateTime regDate;

    //OAuth2
    private String provider;
    private String providerId;

}









