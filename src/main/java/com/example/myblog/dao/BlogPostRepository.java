package com.example.myblog.dao;
import com.example.myblog.domain.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
interface BlogPostRepository extends MongoRepository<BlogPost, String>{

    Optional<BlogPost> findByPostId(String postId);

    void deleteByPostId(String postId);

}
