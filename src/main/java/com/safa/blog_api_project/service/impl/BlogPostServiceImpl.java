package com.safa.blog_api_project.service.impl;

import com.safa.blog_api_project.dto.request.BlogPostRequestDto;
import com.safa.blog_api_project.dto.response.BlogPostResponseDto;
import com.safa.blog_api_project.entity.BlogPost;
import com.safa.blog_api_project.entity.Category;
import com.safa.blog_api_project.entity.Tag;
import com.safa.blog_api_project.exception.ResourceNotFoundException;
import com.safa.blog_api_project.mapper.BlogPostMapper;
import com.safa.blog_api_project.repository.BlogPostRepository;
import com.safa.blog_api_project.repository.CategoryRepository;
import com.safa.blog_api_project.repository.TagRepository;
import com.safa.blog_api_project.service.IBlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements IBlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final BlogPostMapper blogPostMapper;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;

    @Override
    public BlogPostResponseDto createBlogPost(BlogPostRequestDto blogPostRequestDto) {
        Long id = blogPostRequestDto.getCategoryId();
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("kategori bulunamadi"));
        BlogPost blogPost = blogPostMapper.toBlogEntity(blogPostRequestDto);
        blogPost.setCategory(category);

        if(blogPostRequestDto.getTagIds() != null && !blogPostRequestDto.getTagIds().isEmpty()){
            List<Tag> tags =tagRepository.findAllById(blogPostRequestDto.getTagIds());
            blogPost.setTags(tags);
        }

        BlogPost dbBlogPost= blogPostRepository.save(blogPost);
        BlogPostResponseDto blogPostResponseDto = blogPostMapper.toBlogResponse(dbBlogPost);
        return blogPostResponseDto;
    }

    @Override
    public BlogPostResponseDto getBlogPostById(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Getirilecek BlogPost bulunamadi"));
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
                .orElseThrow(()->new ResourceNotFoundException("Silinecek BlogPost bulunamadi"));
        blogPostRepository.delete(blogPost);
    }

    @Override
    public BlogPostResponseDto updateBlogPost(Long id, BlogPostRequestDto blogPostRequestDto) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Guncellenecek BlogPost bulunamadi"));

        Category category = categoryRepository.findById(blogPostRequestDto.getCategoryId())
                .orElseThrow(()->new ResourceNotFoundException("Kategori Bulunamadı"));
        blogPost.setContent(blogPostRequestDto.getContent());
        blogPost.setTitle(blogPostRequestDto.getTitle());
        blogPost.setCategory(category);

        if (blogPostRequestDto.getTagIds() != null && !blogPostRequestDto.getTagIds().isEmpty()){
            List<Tag> tags = tagRepository.findAllById(blogPostRequestDto.getTagIds());
            blogPost.setTags(tags);
        }
        else {
            blogPost.setTags(new ArrayList<>());
        }

       BlogPost dbblogPost = blogPostRepository.save(blogPost);

       return blogPostMapper.toBlogResponse(dbblogPost);

    }
}
