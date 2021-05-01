package com.spring.devblog.service;

import com.spring.devblog.model.Post;

import java.util.List;
import java.util.Optional;

public interface DevblogService {
    List<Post> findAll();
    Optional<Post> findById(Long id);
    Post save(Post post);
}
