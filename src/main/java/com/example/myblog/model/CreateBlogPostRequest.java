package com.example.myblog.model;

import com.example.myblog.model.BlogPostModel;
import lombok.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CreateBlogPostRequest {
    @Valid
    @NotNull
    private BlogPostModel blogModel;
}
