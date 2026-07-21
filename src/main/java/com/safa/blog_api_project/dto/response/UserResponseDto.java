package com.safa.blog_api_project.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private Long id;

    private String username;

    private String email;

    private String role;
}
