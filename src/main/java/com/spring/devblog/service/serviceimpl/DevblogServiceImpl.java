package com.spring.devblog.service.serviceimpl;

import com.spring.devblog.model.Post;
import com.spring.devblog.repository.DevblogRepository;
import com.spring.devblog.service.DevblogService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DevblogServiceImpl implements DevblogService {
    //ponto de injeção, uma instância de DevblogRepository por meio de um campo
    // privado usando a anotação @Autowired . No tempo de execução,
    // Spring Data JPA irá gerar uma instância de proxy de DevblogRepository

    private DevblogRepository dr;

    public DevblogServiceImpl(DevblogRepository dr) {
        this.dr = dr;
    }

    @Override
    public List<Post> findAll() {
        return (List<Post>) dr.findAll();
    }

    @Override
    public Post findById(Long id) {
        return dr.findById(id).get();
    }

    @Override
    public void save(Post post) {
        dr.save(post);
    }

    @Override
    public  void delete(Post post){ dr.delete(post);}


}
