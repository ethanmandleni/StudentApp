/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ctu.studentmanagement.service;

/**
 *
 * @author ethan
 */
public class StudentNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    //report a student ID that does not exist
    public StudentNotFoundException(Long id) {
        super("Student not found with ID: " + id);
    }
}
