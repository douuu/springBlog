package com.example.myblog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;

@Document
@Getter
@Setter
@Builder
public class BlogPost {
    @Id
    private String _id;
    @NotNull
    private String postId;
    private String title;
    private String content;
    private String auth;
}
