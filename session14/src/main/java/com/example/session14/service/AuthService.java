package com.example.session14.service;

import com.example.session14.config.Jwt.JwtService;
import com.example.session14.model.dto.request.UserCreateDTO;
import com.example.session14.model.dto.request.UserLoginDTO;
import com.example.session14.model.dto.response.JwtResponse;
import com.example.session14.model.entity.Role;
import com.example.session14.model.entity.User;
import com.example.session14.principal.UserPrincipal;
import com.example.session14.repository.UserRepository;
import com.example.session14.validator.BadCredentialsExceptionCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

//    đăng ký
    public User createUser(UserCreateDTO req) {
        User newUser = new User();

        newUser.setUsername(req.getUsername());
        newUser.setPassword(passwordEncoder.encode(req.getPassword()));
        newUser.setRole(Role.USER);

        return userRepository.save(newUser);
    }

//    đăng nhập
    public JwtResponse loginByUserNameAndPassword (UserLoginDTO req) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getUsername(),
                            req.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsExceptionCustom("username or password incorrect");
        }

        User user = userRepository.findByUsername(req.getUsername())
                .orElseThrow();

        JwtResponse res = JwtResponse.builder()
                .username(user.getUsername())
                .accessToken(jwtService.generateAccessToken((UserDetails) authentication.getPrincipal()))
                .expirationDate(new Date(new Date().getTime() + 15*60*1000))
                .refreshToken(null)
                .build();
        return res;
    }
}
