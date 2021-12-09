package com.example.myblog.dao;

import com.example.myblog.domain.BlogPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BlogPostDao{

    private final BlogPostRepository repository;

    public Optional<BlogPost> findByPostId(String postId){
        return repository.findByPostId(postId);
    }

    public void deleteByPostId(String postId){
        repository.deleteByPostId(postId);
    }

    public BlogPost save(BlogPost blogPost){
        return repository.save(blogPost);
    }

    public List<BlogPost> findAll(){
        return repository.findAll();
    }

}
