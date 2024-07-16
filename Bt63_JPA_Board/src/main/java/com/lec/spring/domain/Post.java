package com.lec.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  // builder pattern 사용 가능
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "t8_post")
@DynamicInsert //insert 시 null 인 필드 제외
@DynamicUpdate //update 시 null 인 필드 제외
public class Post extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subject; // 제목

    @Column(columnDefinition = "LONGTEXT")
    private String content; // 내용

    @ColumnDefault(value = "0")
    @Column(insertable = false) //DB에 직접 삽입하지 않고 자동으로 설정되거나 생성되는 경우에 사용
    private Long viewCnt; // 조회수

    //Post:User = N:1
    @ManyToOne(optional = false) //작성한 글에는 반드시 작성자가 있어야됨 작성자가 외래키일 수 없음
    // optional = false : user_id bigint not null
    //  이게 없으면 Post 의 find..동작시  Post 와 User 사이에 left outer join 발생
    @ToString.Exclude
    private User user; //글 작성자(FK)

    // 첨부파일
    // Post:File = 1:N
    // cascade = CascadeType.ALL  : 삭제등의 동작 발생시 child 도 함께 삭제
    @OneToMany(cascade = CascadeType.ALL) // Post 가 삭제될 때 관련된 Attachment 도 함께 삭제되도록
    @JoinColumn(name = "post_id")
    @ToString.Exclude
    @Builder.Default   // builder 제공안함
    private List<Attachment> fileList = new ArrayList<>();

    public void addFiles(Attachment... files){
        Collections.addAll(fileList, files);
    }

    // 댓글
    // Post:Comment = 1:N
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    @ToString.Exclude
    @Builder.Default
    private List<Comment> commentList = new ArrayList<>();
    public void addComments(Comment... comments) {
        Collections.addAll(commentList, comments);
    }

}
