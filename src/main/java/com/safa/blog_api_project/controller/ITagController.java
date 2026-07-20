package com.safa.blog_api_project.controller;

import com.safa.blog_api_project.dto.request.TagRequestDto;
import com.safa.blog_api_project.dto.response.TagResponseDto;

import java.util.List;

public interface ITagController {
    public TagResponseDto createTag(TagRequestDto tagRequestDto);

    public TagResponseDto getTagById(Long id);

    public List<TagResponseDto> getAllTag();

    public void deleteTagById(Long id);

    public TagResponseDto updateTag(Long id,TagRequestDto tagRequestDto);
}
