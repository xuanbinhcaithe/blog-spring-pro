package com.codegym.service.impl;

import com.codegym.model.Author;
import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(Blog blog) {
    blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
    blogRepository.delete(id);
    }

    @Override
    public Iterable<Blog> findByAllAuthor(Author author) {
        return blogRepository.findAllByAuthor(author);
    }

    @Override
    public Page<Blog> findAllByNameContaining(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name,pageable);
    }

}
