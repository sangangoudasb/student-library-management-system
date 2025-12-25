package com.example.student.library.management.system.service;

import com.example.student.library.management.system.converters.BookConverter;
import com.example.student.library.management.system.model.Author;
import com.example.student.library.management.system.model.Book;
import com.example.student.library.management.system.model.Card;
import com.example.student.library.management.system.repository.AuthorRepository;
import com.example.student.library.management.system.repository.BookRepository;
import com.example.student.library.management.system.repository.CardRepository;
import com.example.student.library.management.system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CardRepository cardRepository;


    public String saveBook(BookRequestDto bookRequestDto){

        Book book = BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);

        Author author = authorRepository.findById(bookRequestDto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Card card = cardRepository.findById(bookRequestDto.getCardId())
                .orElseThrow(() -> new RuntimeException("Card not found"));

        book.setAuthor(author);
        book.setCard(card);

        bookRepository.save(book);
        return "Book saved successfully";
    }

    // Find by ID
    public Book getBookById(int id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    // Find all
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    // Pagination + sorting
    public List<Book> getBooksByPagination(int pageNo, int pageSize){
        return bookRepository
                .findAll(PageRequest.of(pageNo, pageSize, Sort.by("title").ascending()))
                .getContent();
    }

    // Delete
    public String deleteBookById(int id){
        bookRepository.deleteById(id);
        return "Book with id " + id + " deleted successfully";
    }

    // Update
    public String updateBook(int id, BookRequestDto bookRequestDto){

        Book existingBook = getBookById(id);

        existingBook.setTitle(bookRequestDto.getTitle());
        existingBook.setPublisherName(bookRequestDto.getPublisherName());
        existingBook.setPublishedDate(bookRequestDto.getPublishedDate());
        existingBook.setPages(bookRequestDto.getPages());
        existingBook.setAvailability(bookRequestDto.isAvailability());
        existingBook.setCategory(bookRequestDto.getCategory());
        existingBook.setRackNo(bookRequestDto.getRackNo());

        bookRepository.save(existingBook);
        return "Book updated successfully";
    }

    // Custom queries
    public List<Book> getBooksByCategory(String category){
        return bookRepository.getBooksByCategory(category);
    }

    public List<Book> getAvailableBooks(){
        return bookRepository.getAvailableBooks();
    }
}