package com.codegym.service;

import com.codegym.model.Author;
import com.codegym.model.Blog;

import java.util.List;

public interface BlogService {
    Iterable<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
    Iterable<Blog> findByAllAuthor(Author author);

}
