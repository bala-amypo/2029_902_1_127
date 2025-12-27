package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    
        @GetMapping
            public ResponseEntity<ApiResponse<Map<String, String>>> getStatus() {
                    Map<String, String> status = Map.of(
                                "status", "UP",
                                            "service", "Complaint Prioritization Engine",
                                                        "version", "1.0"
                                                                );
                                                                        return ResponseEntity.ok(ApiResponse.success("Service status retrieved successfully", status));
                                                                            }
                                                                            }