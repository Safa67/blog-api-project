package com.safa.blog_api_project.mapper;

import com.safa.blog_api_project.dto.request.BlogPostRequestDto;
import com.safa.blog_api_project.dto.response.BlogPostResponseDto;
import com.safa.blog_api_project.entity.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TagMapper.class})
public interface BlogPostMapper {

    @Mapping(target = "category",ignore = true)
    BlogPost toBlogEntity(BlogPostRequestDto requestDto);

    @Mapping(source = "category.name",target = "categoryName")
    BlogPostResponseDto toBlogResponse(BlogPost blogPost);

    List<BlogPostResponseDto> toResponseList(List<BlogPost> blogPosts);
}
