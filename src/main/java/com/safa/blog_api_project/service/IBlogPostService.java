package com.safa.blog_api_project.service;

import com.safa.blog_api_project.dto.request.BlogPostRequestDto;
import com.safa.blog_api_project.dto.response.BlogPostResponseDto;

import java.util.List;

public interface IBlogPostService {
    BlogPostResponseDto createBlogPost(BlogPostRequestDto blogPostRequestDto) ;

    BlogPostResponseDto getBlogPostById(Long id);

    List<BlogPostResponseDto> getAllBlogPost(int page, int size);

    void  deleteBlogPostByID(Long id);

    BlogPostResponseDto updateBlogPost(Long id, BlogPostRequestDto blogPostRequestDto);

    List<BlogPostResponseDto> getBlogsByCategoryName(String categoryName, int page, int size);

    List<BlogPostResponseDto> getBlogsByTagName(String tagName, int page, int size);

    List<BlogPostResponseDto> searchBlogs(String keyword, int page, int size);
}
