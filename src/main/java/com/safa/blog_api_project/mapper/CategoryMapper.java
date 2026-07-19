package com.safa.blog_api_project.mapper;

import com.safa.blog_api_project.dto.request.CategoryRequestDto;
import com.safa.blog_api_project.dto.response.CategoryResponseDto;
import com.safa.blog_api_project.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    Category toCategoryEntity(CategoryRequestDto request);

    CategoryResponseDto toCategoryResponse(Category category);

    List<CategoryResponseDto> toCategoryResponseList(List<Category> categories);
}
