package com.example.student.library.management.system.controller;


import com.example.student.library.management.system.model.Author;
import com.example.student.library.management.system.requestdto.AuthorRequestDto;
import com.example.student.library.management.system.requestdto.StudentRequestDto;
import com.example.student.library.management.system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author/apis")
public class AuthorController {

     @Autowired
    AuthorService authorService;

        @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
       String response=authorService.saveAuthor(authorRequestDto);
         return response;
    }

    @GetMapping("/find/{id}")
    public Author findById(@PathVariable int id){
        return authorService.getAuthorById(id);
    }

    @GetMapping("/findAll")
    public List<Author> findAll(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/findAllByPage")
    public List<Author> findAllByPage(@RequestParam int pageNo, @RequestParam int pageSize){
        return authorService.getAuthorsByPagination(pageNo, pageSize);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return authorService.deleteAuthorById(id);
    }

    @PutMapping("/update/{id}")
    public String updateAuthor(
            @PathVariable int id,
            @RequestBody AuthorRequestDto authorRequestDto){
        return authorService.updateAuthor(id, authorRequestDto);
    }

    @GetMapping("/findByEmail")
    public Author getAuthorByEmail(@RequestParam String email){
        return authorService.getAuthorByEmail(email);
    }

    @GetMapping("/findByCountry")
    public List<Author> getAuthorByCountry(@RequestParam String country){
        return authorService.getAuthorByCountry(country);
    }

}
