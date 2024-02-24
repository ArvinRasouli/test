package com.arvin.crudtest.dao;

import com.arvin.crudtest.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);

    void deleteById(int id);
}
