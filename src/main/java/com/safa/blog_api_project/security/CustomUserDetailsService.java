package com.safa.blog_api_project.security;

import com.safa.blog_api_project.entity.User;
import com.safa.blog_api_project.exception.ResourceNotFoundException;
import com.safa.blog_api_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()->new ResourceNotFoundException("Kullanıcı adı bulunamadı" + username));

        return org.springframework.security.core.userdetails.User.builder().username(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
    }
}
