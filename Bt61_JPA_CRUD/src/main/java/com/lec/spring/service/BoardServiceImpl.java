package com.lec.spring.service;

import com.lec.spring.domain.Post;
import com.lec.spring.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    private PostRepository postRepository;

    public BoardServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public int write(Post post) {
        if (post.getViewCnt() == null) {
            post.setViewCnt(0L);
        }
        postRepository.save(post);
        return 1;
    }

    @Override
    @Transactional
    public Post detail(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setViewCnt(post.getViewCnt()+1);
        post = postRepository.save(post);
        return post;
    }

    @Override
    public List<Post> list() {
        List<Post> result = postRepository.findAll();
        return result;
    }

    @Override
    public Post selectById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public int update(Post post) {
        post = postRepository.findById(post.getId()).orElseThrow();
        post.setSubject(post.getSubject());
        post.setContent(post.getContent());
        postRepository.save(post);
        return 1;

    }

    @Override
    public int deleteById(Long id) {
        int result = 0;

        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            postRepository.delete(optionalPost.get());
            result = 1;
        }
        return result;
    }
} // end Service








