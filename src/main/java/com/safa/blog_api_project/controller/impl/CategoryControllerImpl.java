package com.safa.blog_api_project.controller.impl;

import com.safa.blog_api_project.controller.ICategoryController;
import com.safa.blog_api_project.dto.request.CategoryRequestDto;
import com.safa.blog_api_project.dto.response.CategoryResponseDto;
import com.safa.blog_api_project.service.impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Valid
@RequestMapping("/api/categories")
public class CategoryControllerImpl implements ICategoryController {

    private final CategoryServiceImpl categoryService;

    @PostMapping
    @Override
    public CategoryResponseDto createCategory(@Valid @RequestBody CategoryRequestDto requestDto) {
        return categoryService.createCategory(requestDto);
    }

    @GetMapping("/{id}")
    @Override
    public CategoryResponseDto getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    @Override
    public List<CategoryResponseDto> getCategoryAll() {
        return categoryService.getCategoryAll();
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }

    @PutMapping("/{id}")
    @Override
    public CategoryResponseDto updateCategory(@PathVariable Long id,@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.updateCategory(id,categoryRequestDto);
    }
}
