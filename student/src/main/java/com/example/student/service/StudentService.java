package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    public Student updateStudentById(Long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    public List<Student> getStudentsWithAverage() {
        List<Student> students = studentRepository.findAll();
        double average = 0;
        for (Student student : students) {
            average += student.getEnglishLanguage();
            average += student.getMathematics();
            average += student.getDesigningWebPages();
            average += student.getGraphicEditors();
            average += student.getGenericApplications();
            average += student.getBasicsOfProgramming();
            average = average / 6;
            student.setAverage(average);
        }
        return students;
    }

    public List<Student> getStudentsOutstanding() {
        List<Student> students = studentRepository.findAll();
        List<Student> studentsOutstanding = new ArrayList<>();

        for (Student student : students) {
            if (student.getEnglishLanguage() < 5 ||
                    student.getMathematics() < 5 ||
                    student.getDesigningWebPages() < 5 ||
                    student.getGraphicEditors() < 5 ||
                    student.getGenericApplications() < 5 ||
                    student.getBasicsOfProgramming() < 5
            ) {
                studentsOutstanding.add(student);
            }
        }
        return studentsOutstanding;
    }

    public List<Student> getStudentsEminent() {
        List<Student> students = studentRepository.findAll();
        List<Student> studentsEminent = new ArrayList<>();

        for (Student student : students) {
            if (student.getEnglishLanguage() > 5 &&
                    student.getMathematics() > 5 &&
                    student.getDesigningWebPages() > 5 &&
                    student.getGraphicEditors() > 5 &&
                    student.getGenericApplications() > 5 &&
                    student.getBasicsOfProgramming() > 5
            ) {
                studentsEminent.add(student);
            }
        }
        return studentsEminent;
    }
}
