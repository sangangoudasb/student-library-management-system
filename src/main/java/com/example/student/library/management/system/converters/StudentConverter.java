package com.example.student.library.management.system.converters;

import com.example.student.library.management.system.model.Student;
import com.example.student.library.management.system.requestdto.StudentRequestDto;

public class StudentConverter {

    public static Student convertStudentRequestDtoIntoStudent(StudentRequestDto studentrequestdto){

        Student student=new Student();
         student.setName(studentrequestdto.getName());
         student.setEmail(studentrequestdto.getEmail());    //   this is how we convert StudentRequestDto into model class.
         student.setAddress(studentrequestdto.getAddress()); // we get the value from studentrequestdto and set into student object
         student.setGender(studentrequestdto.getGender());
         student.setDept(studentrequestdto.getDept());
         student.setDob(studentrequestdto.getDob());
         student.setSem(studentrequestdto.getSem());
         student.setMobile(studentrequestdto.getMobile());

         return student;

    }

}
