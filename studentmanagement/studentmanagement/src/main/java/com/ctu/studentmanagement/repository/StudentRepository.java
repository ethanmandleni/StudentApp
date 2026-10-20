/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ctu.studentmanagement.repository;
//import the Student model class
import com.ctu.studentmanagement.model.Student;
//import JPA repository for database CRUD
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA provides the CRUD methods
public interface StudentRepository extends JpaRepository<Student, Long> {
}