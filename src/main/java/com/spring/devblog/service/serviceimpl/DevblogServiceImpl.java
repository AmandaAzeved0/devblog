package com.spring.devblog.service.serviceimpl;

import com.spring.devblog.model.Post;
import com.spring.devblog.repository.DevblogRepository;
import com.spring.devblog.service.DevblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevblogServiceImpl implements DevblogService {
    //ponto de injeção
    @Autowired
    DevblogRepository devblogRepository;

    @Override
    public List<Post> findAll() {
        return devblogRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return devblogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return devblogRepository.save(post);
    }
}
