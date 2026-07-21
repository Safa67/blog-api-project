package com.safa.blog_api_project.service.impl;

import com.safa.blog_api_project.dto.request.CommentRequestDto;
import com.safa.blog_api_project.dto.response.CommentResponseDto;
import com.safa.blog_api_project.entity.BlogPost;
import com.safa.blog_api_project.entity.Comment;
import com.safa.blog_api_project.entity.User;
import com.safa.blog_api_project.exception.ResourceNotFoundException;
import com.safa.blog_api_project.mapper.CommentMapper;
import com.safa.blog_api_project.repository.BlogPostRepository;
import com.safa.blog_api_project.repository.CommentRepository;
import com.safa.blog_api_project.repository.UserRepository;
import com.safa.blog_api_project.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final BlogPostRepository blogPostRepository;
    private final UserRepository userRepository;

    @Override
    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
        Comment comment = commentMapper.toCommentEntity(commentRequestDto);

        User author = userRepository.findById(commentRequestDto.getAuthorId())
                .orElseThrow(()->new ResourceNotFoundException("Kullanıcı bulunamadı"));

        BlogPost blogPost = blogPostRepository.findById(commentRequestDto.getBlogId())
                .orElseThrow(()->new ResourceNotFoundException("Post bulunamadi"));

        comment.setAuthor(author);
        comment.setBlogPost(blogPost);
        Comment dbComment = commentRepository.save(comment);
        return commentMapper.toCommentResponse(dbComment);
    }

    @Override
    public List<CommentResponseDto> getAllComment(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Comment> commentsPage = commentRepository.findAll(pageable);
        return commentMapper.toCommentResponseList(commentsPage.getContent());
    }

    @Override
    public CommentResponseDto getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Yorum Bulunamadi"));
        return commentMapper.toCommentResponse(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Silinecek Yorum Bulunamadi"));
        commentRepository.delete(comment);
    }

    @Override
    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Guncellenecek Yorum Bulunamadi"));

        comment.setCommenterName(commentRequestDto.getCommenterName());
        comment.setContent(commentRequestDto.getContent());

        BlogPost blogPost = blogPostRepository.findById(commentRequestDto.getBlogId())
                .orElseThrow(()->new ResourceNotFoundException("Post Bulunamadi"));

        comment.setBlogPost(blogPost);

        Comment dbcomment = commentRepository.save(comment);
        return commentMapper.toCommentResponse(dbcomment);
    }
}
