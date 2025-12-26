package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
        private final UserService userService;
            private final JwtUtil jwtUtil;
                private final AuthenticationManager authenticationManager;
                    
                        public AuthController(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
                                this.userService = userService;
                                        this.jwtUtil = jwtUtil;
                                                this.authenticationManager = authenticationManager;
                                                    }
                                                        
                                                            @PostMapping("/register")
                                                                public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody AuthRequest request) {
                                                                        User user = userService.registerCustomer(request.getEmail(), request.getEmail(), request.getPassword());
                                                                                String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name(), user.getId());
                                                                                        AuthResponse response = new AuthResponse(token, user.getEmail(), user.getRole().name());
                                                                                                return ResponseEntity.ok(ApiResponse.success(response));
                                                                                                    }
                                                                                                        
                                                                                                            @PostMapping("/login")
                                                                                                                public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody AuthRequest request) {
                                                                                                                        Authentication auth = authenticationManager.authenticate(
                                                                                                                                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
                                                                                                                                            
                                                                                                                                                    User user = userService.findByEmail(request.getEmail());
                                                                                                                                                            String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name(), user.getId());
                                                                                                                                                                    AuthResponse response = new AuthResponse(token, user.getEmail(), user.getRole().name());
                                                                                                                                                                            return ResponseEntity.ok(ApiResponse.success(response));
                                                                                                                                                                                }
                                                                                                                                                                                }