package com.ctu.studentmanagement;

//import the Student model
import com.ctu.studentmanagement.model.Student;
//import the StudentService
import com.ctu.studentmanagement.service.StudentService;
//import ResponseEntity to control HTTP responses
import org.springframework.http.ResponseEntity;
//import annotations for REST API endpoints
import org.springframework.web.bind.annotation.*;
//import List to work with lists of students
import java.util.List;
import jakarta.validation.Valid;

//handles web request and return data as JSON
@RestController

@RequestMapping("/api/students")

public class StudentController {  
    
    private final StudentService service;
    
    //return a JSON resonse 
    public StudentController(StudentService service) {
        this.service = service;
    }

    //get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    //get one student
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    //create a student after validating the data
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid 
    @RequestBody Student student) {
    return ResponseEntity.status(201).body(service.createStudent(student));
    }
    
    //update a student after validating the data
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
        @Valid @RequestBody Student student) {
    return service.updateStudent(id, student);
}

    //delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}






    