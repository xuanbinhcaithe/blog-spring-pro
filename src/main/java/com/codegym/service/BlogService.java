package com.codegym.service;

import com.codegym.model.Author;
import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
    Iterable<Blog> findByAllAuthor(Author author);
    Page<Blog> findAllByNameContaining(String name,Pageable pageable);

}
