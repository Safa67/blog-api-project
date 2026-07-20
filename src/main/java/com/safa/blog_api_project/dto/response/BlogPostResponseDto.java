package com.safa.blog_api_project.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BlogPostResponseDto {

    private Long id;

    private String title;

    private String content;

    private String categoryName;

    private List<TagResponseDto> tags;
}
