package com.safa.blog_api_project.service.impl;

import com.safa.blog_api_project.dto.request.UserRequestDto;
import com.safa.blog_api_project.dto.response.UserResponseDto;
import com.safa.blog_api_project.entity.User;
import com.safa.blog_api_project.exception.ResourceNotFoundException;
import com.safa.blog_api_project.mapper.UserMapper;
import com.safa.blog_api_project.repository.UserRepository;
import com.safa.blog_api_project.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.toEntityUser(userRequestDto);
        User dbUser = userRepository.save(user);
        UserResponseDto userResponse=userMapper.toUserResponse(dbUser);
        return userResponse;
    }

    @Override
    public UserResponseDto findUserById(Long id) {
        User user= userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Kullanıcı bulunamadı"));
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponseDto> findAllUser() {
        List<User> userList = userRepository.findAll();
        userMapper.toUserResponseList(userList);
        return userMapper.toUserResponseList(userList);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Kullanıcı Bulunamadı"));

        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());

        User updatedUser = userRepository.save(user);

        return userMapper.toUserResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Kullanıcı Bulunamadı"));

        userRepository.delete(user);
    }
}
