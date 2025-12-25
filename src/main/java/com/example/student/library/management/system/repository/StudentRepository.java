package com.example.student.library.management.system.repository;

import com.example.student.library.management.system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


    // we can write customized querries also. Below i will write some customized querries.

   // 1) this querry is to find student based on email.
    @Query(nativeQuery = true, value= "select * from student where email = :inputEmail")
    public Student getStudentByEmailId(String inputEmail);

   // 2) this querry is to find student based on dept
    @Query(nativeQuery = true, value="select * from student where dept = :inputDept")
   public List<Student> getStudentByDept(String inputDept);


}
