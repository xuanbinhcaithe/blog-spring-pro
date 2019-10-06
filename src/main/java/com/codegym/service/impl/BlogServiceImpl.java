package com.codegym.service.impl;

import com.codegym.model.Author;
import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
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

}
