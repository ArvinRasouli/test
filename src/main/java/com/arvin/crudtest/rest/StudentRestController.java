package com.arvin.crudtest.rest;

import com.arvin.crudtest.entity.Student;
import com.arvin.crudtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arvin")
public class StudentRestController {
    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> findAll(){
        List<Student> studentList = studentService.findAll();
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);
        return student;
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        student.setId(0);
        Student dbStudent = studentService.save(student);
        return dbStudent;
    }

    @PutMapping("/student")
    public Student editeStudent(@RequestBody Student student) {
        Student dbStudent = studentService.save(student);
        return dbStudent;
    }

    @DeleteMapping("student/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        studentService.deleteById(studentId);
        return "Deleted Student by id: " + studentId;
    }
}
