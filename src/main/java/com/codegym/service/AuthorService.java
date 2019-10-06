package com.codegym.service;

import com.codegym.model.Author;

public interface AuthorService  {
    Iterable<Author> findAll();
    Author findById(Long id);
    void save(Author author);
    void remove(Long id);

}
