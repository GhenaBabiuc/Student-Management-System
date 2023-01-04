package com.example.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students", schema = "public")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "english_language")
    private int englishLanguage;

    @Column(name = "mathematics")
    private int mathematics;

    @Column(name = "designing_web_pages")
    private int designingWebPages;

    @Column(name = "graphic_editors")
    private int graphicEditors;

    @Column(name = "generic_applications")
    private int genericApplications;

    @Column(name = "basics_of_programming")
    private int basicsOfProgramming;

    @Transient
    private double average;
}

