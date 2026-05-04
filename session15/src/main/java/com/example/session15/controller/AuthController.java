package com.example.session15.controller;

import com.example.session15.model.dto.request.UserCreateDTO;
import com.example.session15.model.dto.request.UserLoginDTO;
import com.example.session15.model.entity.User;
import com.example.session15.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping
    public String test() {
        return "Auth API public OK";
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO req) {
        User res = authService.createUser(req);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO req) {
        return ResponseEntity.ok(authService.loginByEmailAndPassword(req));
    }
}
