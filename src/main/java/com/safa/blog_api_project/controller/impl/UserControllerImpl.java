package com.safa.blog_api_project.controller.impl;

import com.safa.blog_api_project.controller.IUserController;
import com.safa.blog_api_project.dto.request.UserRequestDto;
import com.safa.blog_api_project.dto.response.UserResponseDto;
import com.safa.blog_api_project.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserControllerImpl implements IUserController {

    private final IUserService userService;

    @PostMapping
    @Override
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @GetMapping("/{id}")
    @Override
    public UserResponseDto findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping
    @Override
    public List<UserResponseDto> findAllUser() {
        return userService.findAllUser();
    }

    @PutMapping("/{id}")
    @Override
    public UserResponseDto updateUser(@PathVariable Long id,@Valid @RequestBody UserRequestDto userRequestDto) {
        return userService.updateUser(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
