/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ctu.studentmanagement.service;


//import the Student model
import com.ctu.studentmanagement.model.Student;
//import the StudentRepository
import com.ctu.studentmanagement.repository.StudentRepository;
//mark this class as a service
import org.springframework.stereotype.Service;
//import List to work with lists of students
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //get all students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    //get one student
    public Student getStudent(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    //add a student
    public Student createStudent(Student student) {
        student.setId(null);
        return repository.save(student);
    }

    //update a student
    public Student updateStudent(Long id, Student details) {
        Student student = getStudent(id);

        student.setName(details.getName());
        student.setEmail(details.getEmail());
        student.setCourse(details.getCourse());

        return repository.save(student);
    }

    //delete a student
    public void deleteStudent(Long id) {
        repository.delete(getStudent(id));
    }
}