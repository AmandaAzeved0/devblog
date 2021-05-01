package com.spring.devblog.repository;

import com.spring.devblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//jpa repository traz metodos de interação com o banco
public interface DevblogRepository extends JpaRepository <Post,Long>{
}
