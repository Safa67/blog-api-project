package com.safa.blog_api_project.controller.impl;

import com.safa.blog_api_project.controller.IBlogPostController;
import com.safa.blog_api_project.dto.request.BlogPostRequestDto;
import com.safa.blog_api_project.dto.response.BlogPostResponseDto;
import com.safa.blog_api_project.service.IBlogPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blogs")
public class BlogPostControllerImpl implements IBlogPostController {

    final private IBlogPostService blogPostService;

    @PostMapping
    @Override
    public BlogPostResponseDto createBlogPost(@Valid @RequestBody BlogPostRequestDto blogPostRequestDto) {
        return blogPostService.createBlogPost(blogPostRequestDto);
    }

    @GetMapping("/{id}")
    @Override
    public BlogPostResponseDto getBlogPostById(@PathVariable Long id) {
        return blogPostService.getBlogPostById(id);
    }

    @GetMapping
    @Override
    public List<BlogPostResponseDto> getAllBlogPost() {
        return blogPostService.getAllBlogPost();
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteBlogPostByID(@PathVariable Long id) {
        blogPostService.deleteBlogPostByID(id);
    }
}
