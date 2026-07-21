package com.safa.blog_api_project.service;

import com.safa.blog_api_project.dto.request.BlogPostRequestDto;
import com.safa.blog_api_project.dto.response.BlogPostResponseDto;

import java.util.List;

public interface IBlogPostService {
    public BlogPostResponseDto createBlogPost(BlogPostRequestDto blogPostRequestDto) ;

    public BlogPostResponseDto getBlogPostById(Long id);

    public List<BlogPostResponseDto> getAllBlogPost(int page, int size);

    public void  deleteBlogPostByID(Long id);

    public BlogPostResponseDto updateBlogPost(Long id, BlogPostRequestDto blogPostRequestDto);
}
