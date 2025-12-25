package com.example.student.library.management.system.repository;

import com.example.student.library.management.system.model.Transcation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscationRepository extends JpaRepository<Transcation, Integer> {

}
