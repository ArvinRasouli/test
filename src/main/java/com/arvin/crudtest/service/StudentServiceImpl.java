package com.arvin.crudtest.service;

import com.arvin.crudtest.dao.StudentDAO;
import com.arvin.crudtest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDAO.findAll();
        return studentList;
    }

    @Override
    public Student findById(int id) {
        Student student = studentDAO.findById(id);
        return student;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        Student student1 = studentDAO.save(student);
        return student1;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }
}
