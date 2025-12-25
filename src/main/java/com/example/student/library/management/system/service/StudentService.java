package com.example.student.library.management.system.service;

import com.example.student.library.management.system.converters.StudentConverter;
import com.example.student.library.management.system.enums.CardStatus;
import com.example.student.library.management.system.model.Card;
import com.example.student.library.management.system.model.Student;
import com.example.student.library.management.system.repository.StudentRepository;
import com.example.student.library.management.system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {


    @Autowired
    StudentRepository studentrepository;

    public String saveStudent(StudentRequestDto studentRequestDto){

        Student student=StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);

        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setExpiryDate(LocalDate.now().plusYears(4).toString());
        card.setStudent(student);

         student.setCard(card);

        studentrepository.save(student);
        return "Student and card saved successfully";
    }

    public Student getStudentById(int id){
        Optional<Student> studentOptional=studentrepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        else{
            //return null;
            throw new RuntimeException("Student not found with id: " + id);
        }
    }


    public List<Student> getAllStudents(){
        List<Student> studentlist=studentrepository.findAll();
        return studentlist;
    }

    /*
    Pagination - fetching the data or records in the form of multiple pages.
    pagenumber - the number of page we want to see(0,1,2,3,4,5,6---).
    pagesize - total number os records in each page(fixed for each page).

    total no of records - 28 , page size - 5
    0th page - 1-5
    1st page - 6-10
    2nd page - 11-15
    3rd page - 16-20
    4th page - 21-25
    5th page - 26-28

    another example -> Total no of records-11, pagesize-3
    0th page- 1-3
    1st page- 4-6
    2nd page- 7-9
    3rd page- 10-11

 If we want only pagination we can use this below method.
     public List<Student> getStudentByPagination(int pageNo, int pageSize){
      List<Student>  studentList = studentrepository.findAll(PageRequest.of(pageNo, pageSize)).getContent();
       return studentList;
  }
     */

    // this below api logic is for both pagination and Sorting.
  public List<Student> getStudentByPagination(int pageNo, int pageSize){
      List<Student>  studentList = studentrepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by("name").ascending())).getContent();
       return studentList;
  }


    public String deleteStudentById(int id){
        studentrepository.deleteById(id);
        return "Student with id " + id + " got deleted successfully!";
    }

    public String updateStudent(int id, StudentRequestDto newStudentRequestDto){
        Student existingStudent=getStudentById(id);
        if(existingStudent!=null){
            existingStudent.setName(newStudentRequestDto.getName());
            existingStudent.setEmail(newStudentRequestDto.getEmail());
            existingStudent.setMobile(newStudentRequestDto.getMobile());
            existingStudent.setDob(newStudentRequestDto.getDob());
            existingStudent.setGender(newStudentRequestDto.getGender());
            existingStudent.setDept(newStudentRequestDto.getDept());
            existingStudent.setAddress(newStudentRequestDto.getAddress());
            existingStudent.setSem(newStudentRequestDto.getSem());

            studentrepository.save(existingStudent);
            return"Student Updated Successfully";
        }
        else{
            return "Student not found, cannot update";
        }

    }

// these below two logics are for customized querries.
    public Student getStudentEmail(String email){
      Student student=studentrepository.getStudentByEmailId(email);
      return student;
    }

    public List<Student> getStudentDept(String dept){
      List<Student> studentList=studentrepository.getStudentByDept(dept);
      return studentList;
    }

}
