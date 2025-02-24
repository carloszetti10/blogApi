package io.github.curso.blogapi.service;

import io.github.curso.blogapi.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);
}