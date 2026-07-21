package com.safa.blog_api_project.repository;

import com.safa.blog_api_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
