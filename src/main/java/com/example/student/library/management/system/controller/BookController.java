package com.example.student.library.management.system.controller;

import com.example.student.library.management.system.converters.BookConverter;
import com.example.student.library.management.system.model.Book;
import com.example.student.library.management.system.requestdto.BookRequestDto;
import com.example.student.library.management.system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/apis")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/save")
    public String saveBook(@RequestBody BookRequestDto bookRequestDto){

        String response=bookService.saveBook(bookRequestDto);
        return response;
    }

    @GetMapping("/find/{id}")
    public Book findById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookService.getAllBooks();
    }

    @GetMapping("/findAllByPage")
    public List<Book> findAllByPage(@RequestParam int pageNo, @RequestParam int pageSize){
        return bookService.getBooksByPagination(pageNo, pageSize);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return bookService.deleteBookById(id);
    }

    @PutMapping("/update/{id}")
    public String updateBook(@PathVariable int id, @RequestBody BookRequestDto bookRequestDto){
        return bookService.updateBook(id, bookRequestDto);
    }

    // Custom APIs
    @GetMapping("/findByCategory")
    public List<Book> getBooksByCategory(@RequestParam String category){
        return bookService.getBooksByCategory(category);
    }

    @GetMapping("/findAvailable")
    public List<Book> getAvailableBooks(){
        return bookService.getAvailableBooks();
    }

}
