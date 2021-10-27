package com.example.demo.services;

import com.example.demo.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudent(Long id) {
       return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student with "+id+" not found"));
    }

    public Student creatStudent(Student student) {
      return   studentRepository.save(student);
    }

    public Student upDate(Long id, Student student) {
        getStudent(id);
        student.setId(id);
       return studentRepository.save(student);
    }

    public void Delete(@PathVariable Long id) {
           studentRepository.deleteById(id);
    }
}
