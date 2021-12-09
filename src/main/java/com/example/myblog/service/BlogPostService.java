package com.example.myblog.service;

import com.example.myblog.dao.BlogPostDao;
import com.example.myblog.domain.BlogPost;
import com.example.myblog.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class BlogPostService {
    private final BlogPostDao dao;

    public UpdateBlogPostResponse update(UpdateBlogPostRequest request){
        Optional<BlogPost> blogPost = dao.findByPostId(request.getBlogPostModel().getPostId());

        if(blogPost.isEmpty()) {
            throw new BlogPostNotFoundException();
        }

        blogPost.get().setContent(request.getBlogPostModel().getContent());
        blogPost.get().setTitle(request.getBlogPostModel().getTitle());

        dao.save(blogPost.get());

        BlogPostModel blogPostModel = BlogPostModel.builder()
                .postId(blogPost.get().getPostId())
                .content(blogPost.get().getContent())
                .title(blogPost.get().getTitle())
                .auth(blogPost.get().getAuth())
                .build();

        UpdateBlogPostResponse updateBlogPostResponse = new UpdateBlogPostResponse();
        updateBlogPostResponse.setBlogPostModel(blogPostModel);

        return updateBlogPostResponse;
    }

    public CreateBlogPostResponse create(CreateBlogPostRequest request) {

        BlogPost post = BlogPost.builder()
                .postId(UUID.randomUUID().toString())
                .auth(request.getBlogModel().getAuth())
                .content(request.getBlogModel().getContent())
                .title(request.getBlogModel().getTitle())
                .build();

        var savedPost = dao.save(post);

        BlogPostModel blogPostModel = BlogPostModel.builder()
                .postId(savedPost.getPostId())
                .auth(savedPost.getAuth())
                .content(savedPost.getContent())
                .title(savedPost.getTitle())
                .build();

        CreateBlogPostResponse createBlogPostResponse = new CreateBlogPostResponse();
        createBlogPostResponse.setBlogPostModel(blogPostModel);

        return createBlogPostResponse;
    }

    public void delete(String postId){
        dao.deleteByPostId(postId);
    }

    public BlogPostModel toBlogPostModel(BlogPost blogPost){
        return BlogPostModel.builder()
                .postId(blogPost.getPostId())
                .content(blogPost.getContent())
                .title(blogPost.getTitle())
                .auth(blogPost.getAuth())
                .build();
    }

    public GetBlogPostResponse findAll(){
        List<BlogPostModel> blogPostModelList = new ArrayList<>();
        List<BlogPost> blogPostList = dao.findAll();
        GetBlogPostResponse getBlogPostResponse = new GetBlogPostResponse();

        if(blogPostList.isEmpty()) {
            throw new BlogPostNotFoundException();
        }

        for(BlogPost post : blogPostList) {
            getBlogPostResponse.getBlogPosts().add(toBlogPostModel(post));
        }


        return getBlogPostResponse;
    }

    public BlogPostModel find(String id){
        Optional<BlogPost> blogPost = dao.findByPostId(id);

        if(blogPost.isEmpty()) {
            throw new BlogPostNotFoundException();
        }

        return toBlogPostModel(blogPost.get());
    }
}
