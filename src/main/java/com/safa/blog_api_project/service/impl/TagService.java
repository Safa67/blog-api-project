package com.safa.blog_api_project.service.impl;

import com.safa.blog_api_project.dto.request.TagRequestDto;
import com.safa.blog_api_project.dto.response.TagResponseDto;
import com.safa.blog_api_project.entity.Tag;
import com.safa.blog_api_project.exception.ResourceNotFoundException;
import com.safa.blog_api_project.mapper.TagMapper;
import com.safa.blog_api_project.repository.TagRepository;
import com.safa.blog_api_project.service.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService implements ITagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    @Override
    public TagResponseDto createTag(TagRequestDto tagRequestDto) {
        Tag tag = tagMapper.toEntityTag(tagRequestDto);
        Tag dbTag= tagRepository.save(tag);
        return tagMapper.toTagResponse(dbTag);
    }

    @Override
    public TagResponseDto getTagById(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Tag bulunamadı"));
        return tagMapper.toTagResponse(tag);
    }

    @Override
    public List<TagResponseDto> getAllTag() {
        List<Tag> tags = tagRepository.findAll();
        return tagMapper.toTagResponseList(tags);
    }

    @Override
    public void deleteTagById(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Silinecek Tag Bulunamadı"));
        tagRepository.delete(tag);
    }
}
