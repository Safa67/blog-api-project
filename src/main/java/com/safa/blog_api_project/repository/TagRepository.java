package com.safa.blog_api_project.repository;

import com.safa.blog_api_project.entity.BlogPost;
import com.safa.blog_api_project.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
}
