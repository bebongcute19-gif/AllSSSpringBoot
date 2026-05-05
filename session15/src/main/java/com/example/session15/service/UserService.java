package com.example.session15.service;
import com.example.session15.model.entity.RoleEnum;
import com.example.session15.model.entity.User;
import com.example.session15.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 🔥 Lấy user hiện tại
    public User getCurrentUser(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 🔥 ADMIN đổi role
    public User updateRole(Long id, RoleEnum role) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole(role);
        return userRepository.save(user);
    }
}