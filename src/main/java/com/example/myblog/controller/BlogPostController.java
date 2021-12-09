package com.example.myblog.controller;

import com.example.myblog.model.*;
import com.example.myblog.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class BlogPostController {
    private final BlogPostService blogPostService;

    @PutMapping
    public BlogPostResponse<UpdateBlogPostResponse> update(@RequestBody UpdateBlogPostRequest request){
        return BlogPostResponse.success(blogPostService.update(request));
    }

    @GetMapping("/{postId}")
    public BlogPostResponse<BlogPostModel> find(@PathVariable String postId){
        return BlogPostResponse.success(blogPostService.find(postId));
    }

    @DeleteMapping("/{postId}")
    public BlogPostResponse<?> delete(@PathVariable String postId){
        blogPostService.delete(postId);
        return BlogPostResponse.empty();
    }

    @GetMapping("/all")
    public BlogPostResponse<GetBlogPostResponse> findAll(){
        return  BlogPostResponse.success(blogPostService.findAll());
    }

    @PostMapping
    public BlogPostResponse<CreateBlogPostResponse> create(@RequestBody @Valid CreateBlogPostRequest request) {
        return BlogPostResponse.success(blogPostService.create(request));
    }

}
