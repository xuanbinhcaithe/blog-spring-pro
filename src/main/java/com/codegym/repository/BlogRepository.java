package com.codegym.repository;

import com.codegym.model.Author;
import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
    Iterable<Blog> findAllByAuthor(Author author);
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

}
