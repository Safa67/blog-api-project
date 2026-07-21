package com.safa.blog_api_project.controller.impl;

import com.safa.blog_api_project.controller.ICommentController;
import com.safa.blog_api_project.dto.request.CommentRequestDto;
import com.safa.blog_api_project.dto.response.CommentResponseDto;
import com.safa.blog_api_project.service.ICommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentControllerImpl implements ICommentController {

    private final ICommentService commentService;

    @PostMapping
    @Override
    public CommentResponseDto createComment(@Valid @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(commentRequestDto);
    }

    @GetMapping
    @Override
    public List<CommentResponseDto> getAllComment(@RequestParam(defaultValue = "0") int page ,
                                                  @RequestParam(defaultValue = "10") int size) {
        return commentService.getAllComment(page,size);
    }

    @GetMapping("/{id}")
    @Override
    public CommentResponseDto getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteCommentById(@PathVariable Long id) {
        commentService.deleteCommentById(id);
    }

    @PutMapping("/{id}")
    @Override
    public CommentResponseDto updateComment(@PathVariable Long id,@Valid @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(id,commentRequestDto);
    }
}
