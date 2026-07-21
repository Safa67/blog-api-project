package com.safa.blog_api_project.service;

import com.safa.blog_api_project.dto.request.BlogPostRequestDto;
import com.safa.blog_api_project.dto.request.CommentRequestDto;
import com.safa.blog_api_project.dto.response.BlogPostResponseDto;
import com.safa.blog_api_project.dto.response.CommentResponseDto;

import java.util.List;

public interface ICommentService {

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto);

    public List<CommentResponseDto> getAllComment(int page,int size);

    public CommentResponseDto getCommentById(Long id);

    public void deleteCommentById(Long id);

    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto);
}
