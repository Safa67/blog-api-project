package com.safa.blog_api_project.controller;

import com.safa.blog_api_project.dto.request.UserRequestDto;
import com.safa.blog_api_project.dto.response.UserResponseDto;

import java.util.List;

public interface IUserController {
    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto findUserById(Long id);

    List<UserResponseDto> findAllUser(int page,int size);

    UserResponseDto updateUser(Long id , UserRequestDto userRequestDto);

    void deleteUser(Long id);
}
