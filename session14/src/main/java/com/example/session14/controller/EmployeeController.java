package com.example.session14.controller;

import com.example.session14.model.dto.request.EmployeeCreateDTO;
import com.example.session14.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@Valid @ModelAttribute EmployeeCreateDTO req) {
        return new ResponseEntity<>(employeeService.createEmployee(req), HttpStatus.CREATED);
    }
}

