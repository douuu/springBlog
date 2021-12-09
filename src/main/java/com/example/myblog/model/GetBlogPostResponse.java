package com.example.myblog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetBlogPostResponse {

    private List<BlogPostModel> blogPosts = new ArrayList<>();

}
