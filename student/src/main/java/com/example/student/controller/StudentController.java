package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedStudent);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudentById(id, student);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudentByIdRequestParam(@RequestParam Long id, @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudentById(id, student));
    }

    @GetMapping("/average")
    public ResponseEntity<List<Student>> getStudentsWithAverage() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsWithAverage());
    }

    @GetMapping("/getStudentsOutstanding")
    public ResponseEntity<List<Student>> getStudentsOutstanding() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsOutstanding());
    }

    @GetMapping("/getStudentsEminent")
    public ResponseEntity<List<Student>> getStudentsEminent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsEminent());
    }
}
