package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;

    @GetMapping("/{id}")
    public Student getId(@PathVariable Long id){
        return studentService.getStudent(id);
    }


    @PostMapping
    public ResponseEntity<Student> creatStudent(@RequestBody Student student){
       return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.creatStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> upDate(@PathVariable Long id, @RequestBody Student student){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.upDate(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> Delete(@PathVariable Long id ){
        studentService.Delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
