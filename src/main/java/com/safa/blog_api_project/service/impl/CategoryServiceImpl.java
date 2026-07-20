package com.safa.blog_api_project.service.impl;

import com.safa.blog_api_project.dto.request.CategoryRequestDto;
import com.safa.blog_api_project.dto.response.CategoryResponseDto;
import com.safa.blog_api_project.entity.Category;
import com.safa.blog_api_project.exception.ResourceNotFoundException;
import com.safa.blog_api_project.mapper.CategoryMapper;
import com.safa.blog_api_project.repository.CategoryRepository;
import com.safa.blog_api_project.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
        Category category = categoryMapper.toCategoryEntity(requestDto);
        Category dbCategory = categoryRepository.save(category);
        CategoryResponseDto categoryResponse =categoryMapper.toCategoryResponse(dbCategory);
        return categoryResponse;
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        Category category =categoryRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Kategori Bulunamadı"));
        CategoryResponseDto categoryResponseDto = categoryMapper.toCategoryResponse(category);
        return categoryResponseDto;
    }

    @Override
    public List<CategoryResponseDto> getCategoryAll() {
        List<Category> categories= categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtos = categoryMapper.toCategoryResponseList(categories);
        return categoryResponseDtos;
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category category =categoryRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Kategori Bulunamadı"));
        categoryRepository.delete(category);
    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto requestDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Güncellenecek Kategori Bulunamadı"));
        category.setName(requestDto.getName());
        Category dbCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryResponse(dbCategory);
    }
}
