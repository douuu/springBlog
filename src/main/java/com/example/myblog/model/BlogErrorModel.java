package com.example.myblog.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class BlogErrorModel {
    private final String code;
    private final String message;
}
