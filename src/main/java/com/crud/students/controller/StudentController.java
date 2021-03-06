package com.crud.students.controller;

import com.crud.students.model.Student;
import com.crud.students.model.dto.StudentDto;
import com.crud.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents()throws Exception{
        //List<Student> students = studentService.getAll();
        List<StudentDto> studentsDto = studentService.getStudentsDto();
        return new ResponseEntity<List<StudentDto>>(studentsDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) throws Exception{
            Student studentDB = studentService.save(student);
            return new ResponseEntity<Student>(student,HttpStatus.CREATED);
    }


}
