package com.example.student.library.management.system.controller;

import com.example.student.library.management.system.model.Student;
import com.example.student.library.management.system.requestdto.StudentRequestDto;
import com.example.student.library.management.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

   @Autowired
   StudentService studentService;    // autowired creates object i.e spring creates automatically if u write this annotation.

   @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){ // requestbody converts json object to java object.
      try{
        String response = studentService.saveStudent(studentRequestDto);
        return response;
    } catch (Exception e) {
          System.out.println("exception occured: " + e.getMessage());
          return "exception occured: " + e.getMessage();
      }
      }

   @GetMapping("/find/{id}")
    public Student findById(@PathVariable int id) {
       try {
           Student response = studentService.getStudentById(id);
           return response;
       } catch (Exception e) {
           System.out.println("exception occured: " + e.getMessage());
           throw new RuntimeException("exception occured: " + e.getMessage());
       }
   }

    @GetMapping("/findAll")
    public List<Student> findAll(){
       List<Student> response=studentService.getAllStudents();
       return response;
    }

    @GetMapping("/findAllByPage")
    public List<Student> findAllByPage(@RequestParam int pageNo, @RequestParam int pageSize){  // if you are taking single single parameters apart from id we can use @requestParam annotation.
       List<Student> response=studentService.getStudentByPagination(pageNo, pageSize);            // @pathVariable annotation is for Primary key.    @RequestBody annotation for whole class to convert into JSON Object.
       return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
         String response=studentService.deleteStudentById(id);
         return response;
    }


    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody StudentRequestDto studentRequestDto){
              String response=studentService.updateStudent(id, studentRequestDto);
              return response;
    }


    //these two apis written for customized querries.
    // In real time i.e in amazon or flkt we will filter by brand or by color right. same way we filter by email, dept etc.
    @GetMapping("/findByEmail")
       public Student getStudentByEmail(@RequestParam String email){
            Student response=studentService.getStudentEmail(email);
            return response;
        }


    @GetMapping("/findByDept")
    public List<Student> getStudentByDept(@RequestParam String dept){
       List<Student> response=studentService.getStudentDept(dept);
       return response;
    }

}
