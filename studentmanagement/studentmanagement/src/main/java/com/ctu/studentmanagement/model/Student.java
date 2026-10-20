/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ctu.studentmanagement.model;

//import the Student model class
import jakarta.persistence.*;
//import JPA repository for database CRUD
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotBlank(message = "Course is required")
    private String course;

    public Student() {} // Required by JPA

    //getters
    public Long getId() {
        return id; 
    }
    public String getName() { 
        return name; 
    }
    
    public String getEmail() { 
        return email;
    }
    
    public String getCourse() { 
        return course; 
    }
    
    //setters    
    public void setId(Long id) {
        this.id = id; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
  
    public void setEmail(String email) {
        this.email = email; 
    }
  
    public void setCourse(String course) {
        this.course = course; 
    }
}