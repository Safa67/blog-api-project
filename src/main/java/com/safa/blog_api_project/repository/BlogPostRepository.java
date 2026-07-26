package com.safa.blog_api_project.repository;

import com.safa.blog_api_project.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {

    Page<BlogPost> findByCategory_Name(String categoryName, Pageable pageable);

    Page<BlogPost> findByTags_Name(String tagName, Pageable pageable);

    Page<BlogPost> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content, Pageable pageable);
}
