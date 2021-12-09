package com.example.myblog.model;

import com.example.myblog.model.BlogPostModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UpdateBlogPostRequest {
    @Valid
    @NotNull
    private BlogPostModel blogPostModel;
}
