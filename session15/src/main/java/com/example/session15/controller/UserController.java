package com.example.session15.controller;

import com.example.session15.model.entity.RoleEnum;
import com.example.session15.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private String getEmail() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
    }

    // ✅ lấy thông tin user hiện tại
    @GetMapping("/me")
    public ResponseEntity<?> me() {
        return ResponseEntity.ok(userService.getCurrentUser(getEmail()));
    }

    // ✅ ADMIN đổi role
    @PutMapping("/{id}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateRole(@PathVariable Long id,
                                        @RequestParam RoleEnum role) {
        return ResponseEntity.ok(userService.updateRole(id, role));
    }
}
