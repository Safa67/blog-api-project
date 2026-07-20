package com.safa.blog_api_project.service;

import com.safa.blog_api_project.dto.request.TagRequestDto;
import com.safa.blog_api_project.dto.response.TagResponseDto;

import java.util.List;

public interface ITagService {
    public TagResponseDto createTag(TagRequestDto tagRequestDto);

    public TagResponseDto getTagById(Long id);

    public List<TagResponseDto> getAllTag();

    public void deleteTagById(Long id);
}
