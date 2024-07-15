package com.lec.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t8_user")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;  // 회원 아이디

    @Column(nullable = false)
    @JsonIgnore
    private String password;  // 회원 비밀번호

    @Transient //Entity에 반영안함. 폼데이터받고 검증용도 데이터베이스에 반영안함
    @ToString.Exclude   //ToString에서 제외
    @JsonIgnore
    private String re_password;  // 비밀번호 확인 입력

    @Column(nullable = false)
    private String name;  // 회원 이름
    private String email;   // 이메일

    //fetch 기본값
    //OneToMany, @ManyToOne -> FetchType.Lazy
    //@ManyToOne, @OneToOne -> FetchType.Eager

    @ManyToMany(fetch = FetchType.EAGER) //user를 불러올때 권한같이불러오기위해
    @ToString.Exclude
    @Builder.Default
    @JsonIgnore
    private List<Authority> authorities = new ArrayList<>();

    public void addAuthority(Authority...authorities){
        Collections.addAll(this.authorities, authorities);
    }

    //OAuth2
    private String provider;
    private String providerId;

}









