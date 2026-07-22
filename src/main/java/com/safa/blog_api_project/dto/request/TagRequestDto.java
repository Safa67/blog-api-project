package com.safa.blog_api_project.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagRequestDto {

    @Size(min = 2, max = 20)
    @NotBlank
    private String name;
}
