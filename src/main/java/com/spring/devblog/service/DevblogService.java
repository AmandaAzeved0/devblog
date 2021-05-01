package com.spring.devblog.service;

import com.spring.devblog.model.Post;

import java.util.List;

public interface DevblogService {
    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);
}
