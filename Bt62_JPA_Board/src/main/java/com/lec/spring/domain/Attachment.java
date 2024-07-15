package com.lec.spring.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    //private Long post_id;  // 어느글의 첨부파일? (FK)

    private String sourcename;   // 원본 파일명
    private String filename;  // 저장된 파일명 (rename 된 파일명)

    private boolean isImage;   // 이미지 여부

}
