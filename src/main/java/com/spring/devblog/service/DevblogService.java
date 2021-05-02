package com.spring.devblog.service;

import com.spring.devblog.model.Post;


import java.util.List;

public interface DevblogService {

    List<Post> findAll();
    void save(Post post);
    Post findById(Long id);
    void delete(Post post);

}
