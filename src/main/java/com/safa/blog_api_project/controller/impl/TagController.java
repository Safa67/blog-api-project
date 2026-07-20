package com.safa.blog_api_project.controller.impl;

import com.safa.blog_api_project.controller.ITagController;
import com.safa.blog_api_project.dto.request.TagRequestDto;
import com.safa.blog_api_project.dto.response.TagResponseDto;
import com.safa.blog_api_project.service.ITagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagController implements ITagController {

    private final ITagService tagService;

    @PostMapping()
    @Override
    public TagResponseDto createTag(@Valid @RequestBody TagRequestDto tagRequestDto) {
        return tagService.createTag(tagRequestDto);
    }

    @GetMapping("/{id}")
    @Override
    public TagResponseDto getTagById(@PathVariable Long id) {
        return tagService.getTagById(id);
    }

    @GetMapping
    @Override
    public List<TagResponseDto> getAllTag() {
        return tagService.getAllTag();
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteTagById(@PathVariable Long id) {
        tagService.deleteTagById(id);
    }
}
