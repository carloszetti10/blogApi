package io.github.curso.blogapi.repository;

import io.github.curso.blogapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository <Post, Long>  {
}
