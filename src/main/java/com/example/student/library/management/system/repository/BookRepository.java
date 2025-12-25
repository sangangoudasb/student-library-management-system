package com.example.student.library.management.system.repository;

import com.example.student.library.management.system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Find books by category
    @Query(nativeQuery = true, value = "select * from book where category = :inputCategory")
    List<Book> getBooksByCategory(String inputCategory);

    // Find available books
    @Query(nativeQuery = true, value = "select * from book where availability = true")
    List<Book> getAvailableBooks();
}
