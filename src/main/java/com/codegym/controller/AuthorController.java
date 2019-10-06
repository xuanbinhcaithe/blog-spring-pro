package com.codegym.controller;

import com.codegym.model.Author;
import com.codegym.model.Blog;
import com.codegym.service.AuthorService;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BlogService blogService;
    @GetMapping("/view-author/{id}")
    public ModelAndView viewAuthor(@PathVariable Long id){
        Author author =  authorService.findById(id);
        if (author == null) {
            return new ModelAndView("/error.404");
        }
        Iterable<Blog> blogs = blogService.findByAllAuthor(author);
        ModelAndView modelAndView = new ModelAndView("/author/view");
        modelAndView.addObject("blog",blogs);
        modelAndView.addObject("author",author);
        return modelAndView;
    }
    @GetMapping("/create-author")
    public ModelAndView showCreateAuthor(){
        ModelAndView modelAndView = new ModelAndView("/author/create");
        modelAndView.addObject("author",new Author());
        return modelAndView;
    }
    @PostMapping("/create-author")
    public ModelAndView saveAuthor(@ModelAttribute("author") Author author) {
    authorService.save(author);
    ModelAndView modelAndView = new ModelAndView("/author/create");
    modelAndView.addObject("author",new Author());
    modelAndView.addObject("message","Successfully!");
    return modelAndView;
    }
    @GetMapping("/authors")
    public ModelAndView listAuthor() {
        Iterable<Author> authors = authorService.findAll();
        ModelAndView modelAndView = new ModelAndView("/author/list");
        modelAndView.addObject("author",authors);
        return modelAndView;
    }
    @GetMapping("/edit-author/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Author author = authorService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/author/edit");
        modelAndView.addObject("author",author);
        return modelAndView;
    }
    @PostMapping("/edit-author")
    public ModelAndView updateAuthor(@ModelAttribute("author") Author author) {
        authorService.save(author);
        ModelAndView modelAndView = new ModelAndView("/author/edit");
        modelAndView.addObject("author",author);
        modelAndView.addObject("message","Successfully!");
        return modelAndView;
    }
    @GetMapping("/delete-author/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Author author = authorService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/author/delete");
        modelAndView.addObject("author",author);
        return modelAndView;
    }
    @PostMapping("/delete-author")
    public String deleteAuthor(@ModelAttribute("author") Author author) {
        authorService.remove(author.getId());
        return "redirect:authors";
    }
}
