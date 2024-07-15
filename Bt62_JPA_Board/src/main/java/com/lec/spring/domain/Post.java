package com.lec.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //기본키 자동 생성
    private Long id;

    @Column(nullable = false)
    private String user; //글 작성자(FK)


    @Column(nullable = false)
    private String subject; // 제목

    @Column(columnDefinition = "LONGTEXT")
    private String content; // 내용

    private LocalDateTime regDate; // 작성일

    @ColumnDefault(value = "0")
    @Column(insertable = false)
    private Long viewCnt; // 조회수

    @OneToMany


    // 첨부파일
    @ToString.Exclude
    @Builder.Default   // builder 제공안함
    private List<Attachment> fileList = new ArrayList<>();

    @PrePersist
    private void prePersist(){
        this.regDate = LocalDateTime.now();
    }


}
