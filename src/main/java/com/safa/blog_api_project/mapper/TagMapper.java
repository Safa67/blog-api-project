package com.safa.blog_api_project.mapper;

import com.safa.blog_api_project.dto.request.TagRequestDto;
import com.safa.blog_api_project.dto.response.TagResponseDto;
import com.safa.blog_api_project.entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tag toEntityTag (TagRequestDto tagRequestDto);

    TagResponseDto toTagResponse(Tag tag);

    List<TagResponseDto> toTagResponseList(List<Tag> tags);


}
