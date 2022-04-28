package com.crud.students.service;

import com.crud.students.model.Student;
import com.crud.students.model.dto.StudentDto;

import java.util.List;

public interface StudentService extends GenericCrud<Student,Long>{

    public List<StudentDto> getStudentsDto() throws Exception;

}
