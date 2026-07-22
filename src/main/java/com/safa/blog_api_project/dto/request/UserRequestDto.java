package com.safa.blog_api_project.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRequestDto {

    @Size(min = 3, max = 15)
    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @Size(min = 6 , max = 20)
    @NotBlank
    private String password;

}
