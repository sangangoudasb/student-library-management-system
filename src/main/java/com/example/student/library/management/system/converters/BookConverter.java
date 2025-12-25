package com.example.student.library.management.system.converters;

import com.example.student.library.management.system.model.Author;
import com.example.student.library.management.system.model.Book;
import com.example.student.library.management.system.requestdto.AuthorRequestDto;
import com.example.student.library.management.system.requestdto.BookRequestDto;

public class BookConverter {

    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto) {

        Book book=new Book();

        book.setTitle(bookRequestDto.getTitle());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setPages(bookRequestDto.getPages());
        book.setAvailability(bookRequestDto.isAvailability());
        book.setCategory(bookRequestDto.getCategory());
        book.setPublishedDate(bookRequestDto.getPublishedDate());
        book.setRackNo(bookRequestDto.getRackNo());

        return book;
    }

}
