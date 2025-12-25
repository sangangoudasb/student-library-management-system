package com.example.student.library.management.system.service;

import com.example.student.library.management.system.converters.AuthorConverter;
import com.example.student.library.management.system.model.Author;
import com.example.student.library.management.system.repository.AuthorRepository;
import com.example.student.library.management.system.requestdto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

  public String saveAuthor(AuthorRequestDto authorRequestDto){

    Author author=AuthorConverter.converAuthorRequestDtoIntoAuthor(authorRequestDto);
    authorRepository.save(author);

    return "Author saved successfully";
}


    public Author getAuthorById(int id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        } else {
            throw new RuntimeException("Author not found with id: " + id);
        }
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public List<Author> getAuthorsByPagination(int pageNo, int pageSize){
        return authorRepository
                .findAll(PageRequest.of(pageNo, pageSize, Sort.by("name").ascending()))
                .getContent();
    }

    public String deleteAuthorById(int id){
        authorRepository.deleteById(id);
        return "Author with id " + id + " deleted successfully";
    }

    public String updateAuthor(int id, AuthorRequestDto authorRequestDto){
        Author existingAuthor = getAuthorById(id);

        existingAuthor.setName(authorRequestDto.getName());
        existingAuthor.setEmail(authorRequestDto.getEmail());
        existingAuthor.setGender(authorRequestDto.getGender());
        existingAuthor.setCountry(authorRequestDto.getCountry());
        existingAuthor.setRating(authorRequestDto.getRating());

        authorRepository.save(existingAuthor);
        return "Author updated successfully";
    }

    public Author getAuthorByEmail(String email){
        return authorRepository.getAuthorByEmail(email);
    }

    public List<Author> getAuthorByCountry(String country){
        return authorRepository.getAuthorByCountry(country);
    }
}


