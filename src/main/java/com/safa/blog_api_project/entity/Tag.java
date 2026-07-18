package com.safa.blog_api_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tag")
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30,nullable = false,unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<BlogPost> blogs;
}
