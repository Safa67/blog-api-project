package com.safa.blog_api_project.controller;



import com.safa.blog_api_project.dto.request.BlogPostRequestDto;
import com.safa.blog_api_project.dto.response.BlogPostResponseDto;

import java.util.List;

public interface IBlogPostController {
    public BlogPostResponseDto createBlogPost(BlogPostRequestDto blogPostRequestDto) ;

    public BlogPostResponseDto getBlogPostById(Long id);

    public List<BlogPostResponseDto> getAllBlogPost();

    public void  deleteBlogPostByID(Long id);

}
