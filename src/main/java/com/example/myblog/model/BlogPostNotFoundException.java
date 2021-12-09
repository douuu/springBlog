package com.example.myblog.model;

import com.example.myblog.common.model.BusinessException;

public class BlogPostNotFoundException extends BusinessException {

    public BlogPostNotFoundException(){
        this("The specified post can not be found.");
    }

    public BlogPostNotFoundException(String message){
        super("BP-001", message);
    }

}
