package com.example.student.library.management.system.converters;

import com.example.student.library.management.system.model.Author;
import com.example.student.library.management.system.requestdto.AuthorRequestDto;

public class AuthorConverter {

//    converter : it converts the requestDto into model classes so that model class gets saved in database as table date.

    public static Author converAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto) {

        Author author=new Author();

        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setGender(authorRequestDto.getGender());
        author.setCountry(authorRequestDto.getCountry());
        author.setRating(authorRequestDto.getRating());

        return author;
    }

}

