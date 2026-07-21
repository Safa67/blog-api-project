package com.safa.blog_api_project.mapper;

import com.safa.blog_api_project.dto.request.CommentRequestDto;
import com.safa.blog_api_project.dto.response.CommentResponseDto;
import com.safa.blog_api_project.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "blogPost",ignore = true)
    Comment toCommentEntity (CommentRequestDto commentRequest);

    @Mapping(source = "author.username", target = "authorUsername")
    CommentResponseDto toCommentResponse ( Comment comment);

    List<CommentResponseDto> toCommentResponseList (List<Comment> comments);
}
