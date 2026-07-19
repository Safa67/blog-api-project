package com.safa.blog_api_project.dto.request;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    @NotBlank
    @Size(min = 2 , max = 50)
    private String commenterName;

    @NotBlank
    private String content;

    @NotNull
    private Long blogId;
}
