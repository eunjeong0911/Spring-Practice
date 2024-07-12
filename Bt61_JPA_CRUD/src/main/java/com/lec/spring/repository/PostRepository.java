package com.lec.spring.repository;

import com.lec.spring.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;
import java.util.List;

// Repository layer(aka. Data layer)
// DataSource (DB) 등에 대한 직접적인 접근
public interface PostRepository extends JpaRepository<Post, Long> {
    // TODO :
    //  가급적 기본 JPA 메소드로만 구현해보세요
    //  필요하면 query method 선언해서 사용해도 됨.
    



}












