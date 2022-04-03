package com.crud.students.service.impl;

import com.crud.students.model.Student;
import com.crud.students.repository.GenericRepository;
import com.crud.students.repository.StudentRepository;
import com.crud.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends GenericCrudImpl<Student,Long> implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    protected GenericRepository<Student, Long> getRepo() {
        return studentRepository;
    }



}
