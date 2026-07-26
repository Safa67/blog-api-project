package com.safa.blog_api_project.dto.response;

import com.safa.blog_api_project.entity.BlogPost;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto {

    private Long id;

    private String commenterName;

    private String content;

    private String authorUsername;

    private BlogPost post;
}
