package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/priority-rules")
public class PriorityRuleController {
    
    private final PriorityRuleService priorityRuleService;
    
    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }
    
    @GetMapping
    public ResponseEntity<ApiResponse<List<PriorityRule>>> getActiveRules() {
        List<PriorityRule> rules = priorityRuleService.getActiveRules();
        return ResponseEntity.ok(ApiResponse.success(rules));
    }
}