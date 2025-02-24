package io.github.curso.blogapi.service.serviceImpl;

import io.github.curso.blogapi.model.Post;
import io.github.curso.blogapi.repository.BlogRepository;
import io.github.curso.blogapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements PostService {

    @Autowired
    BlogRepository repository;

    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }
}
