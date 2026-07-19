package com.safa.blog_api_project.service.impl;

import com.safa.blog_api_project.dto.request.BlogPostRequestDto;
import com.safa.blog_api_project.dto.response.BlogPostResponseDto;
import com.safa.blog_api_project.entity.BlogPost;
import com.safa.blog_api_project.entity.Category;
import com.safa.blog_api_project.mapper.BlogPostMapper;
import com.safa.blog_api_project.repository.BlogPostRepository;
import com.safa.blog_api_project.repository.CategoryRepository;
import com.safa.blog_api_project.service.IBlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements IBlogPostService {
    private final BlogPostRepository blogPostRepository;
    private final BlogPostMapper blogPostMapper;
    private final CategoryRepository categoryRepository;


    @Override
    public BlogPostResponseDto createBlogPost(BlogPostRequestDto blogPostRequestDto) {
        Long id = blogPostRequestDto.getCategoryId();
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("kategori bulunamadi"));
        BlogPost blogPost = blogPostMapper.toBlogEntity(blogPostRequestDto);
        blogPost.setCategory(category);
        BlogPost dbBlogPost= blogPostRepository.save(blogPost);
        BlogPostResponseDto blogPostResponseDto = blogPostMapper.toBlogResponse(dbBlogPost);
        return blogPostResponseDto;
    }

    @Override
    public BlogPostResponseDto getBlogPostById(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Getirilecek BlogPost bulunamadi"));
        BlogPostResponseDto blogPostResponseDto =blogPostMapper.toBlogResponse(blogPost);

        return blogPostResponseDto;
    }


    @Override
    public List<BlogPostResponseDto> getAllBlogPost() {
        List<BlogPost> blogPosts = blogPostRepository.findAll();
        List<BlogPostResponseDto> blogPostResponseDtos=blogPostMapper.toResponseList(blogPosts);
        return blogPostResponseDtos;
    }

    @Override
    public void deleteBlogPostByID(Long id) {
        BlogPost blogPost =blogPostRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Silinecek BlogPost bulunamadi"));
        blogPostRepository.delete(blogPost);
    }
}
