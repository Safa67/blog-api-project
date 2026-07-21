package com.safa.blog_api_project.mapper;

import com.safa.blog_api_project.dto.request.UserRequestDto;
import com.safa.blog_api_project.dto.response.UserResponseDto;
import com.safa.blog_api_project.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntityUser (UserRequestDto userRequestDto);

    UserResponseDto toUserResponse (User user);

    List<UserResponseDto> toUserResponseList (List<User> userList);
}
