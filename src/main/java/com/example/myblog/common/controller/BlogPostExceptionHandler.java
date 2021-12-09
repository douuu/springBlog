package com.example.myblog.common.controller;
import com.example.myblog.model.BlogPostResponse;
import com.example.myblog.common.model.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class BlogPostExceptionHandler{

    @ExceptionHandler(value = {BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BlogPostResponse<?> handleBlogPostException(BusinessException e){
        return BlogPostResponse.failure(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
    }

}
