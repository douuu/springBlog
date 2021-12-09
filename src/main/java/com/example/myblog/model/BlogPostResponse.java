package com.example.myblog.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlogPostResponse<T>{

    private boolean success = true;
    private T responseBody;
    private BlogErrorModel error;

    public static BlogPostResponse<?> empty() {
        return new BlogPostResponse<>();
    }

    public static <T> BlogPostResponse<T> success(T responseBody){
        BlogPostResponse<T> response = new BlogPostResponse<T>();
        response.setResponseBody(responseBody);
        return response;
    }

    public static BlogPostResponse<?> success(){
        BlogPostResponse<?> response = new BlogPostResponse<>();
        return response;
    }

    public static BlogPostResponse<?> failure(String errorMessage, String errorCode){
            BlogPostResponse<?> response = new BlogPostResponse<>();
            BlogErrorModel error = new BlogErrorModel(errorMessage, errorCode);

            response.setError(error);
            response.setSuccess(false);
            return response;
    }

}
