package com.example.myblog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class BlogPostModel{
    private String postId;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private String auth;

}
