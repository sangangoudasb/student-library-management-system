package com.example.student.library.management.system.repository;

import com.example.student.library.management.system.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query(nativeQuery = true, value = "select * from author where email = :inputEmail")
    Author getAuthorByEmail(String inputEmail);

    @Query(nativeQuery = true, value = "select * from author where country = :inputCountry")
    List<Author> getAuthorByCountry(String inputCountry);

}
