package com.arvin.crudtest.dao;

import com.arvin.crudtest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentDAOJpaImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("from Student ", Student.class);
        return studentTypedQuery.getResultList();
    }

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public Student save(Student student) {
        Student student1 = entityManager.merge(student);
        return student1;
    }

    @Override
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
