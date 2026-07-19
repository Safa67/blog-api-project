package com.safa.blog_api_project.repository;

import com.safa.blog_api_project.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {
}
