package com.safa.blog_api_project.service;

import com.safa.blog_api_project.dto.request.CategoryRequestDto;
import com.safa.blog_api_project.dto.response.CategoryResponseDto;

import java.util.List;

public interface ICategoryService {
    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) ;

    public CategoryResponseDto getCategoryById(Long id) ;

    public List<CategoryResponseDto> getCategoryAll() ;

    public void deleteCategoryById(Long id) ;
}
