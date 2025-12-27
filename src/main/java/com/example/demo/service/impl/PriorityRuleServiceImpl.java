package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {
    private final PriorityRuleRepository priorityRuleRepository;

    @Autowired
    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public int computePriorityScore(Complaint complaint) {
        List<PriorityRule> activeRules = getActiveRules();
        int score = 0;

        // Base score from severity
        if (complaint.getSeverity() != null) {
            switch (complaint.getSeverity()) {
                case LOW -> score += 1;
                case MEDIUM -> score += 3;
                case HIGH -> score += 5;
                case CRITICAL -> score += 8;
            }
        }

        // Base score from urgency
        if (complaint.getUrgency() != null) {
            switch (complaint.getUrgency()) {
                case LOW -> score += 1;
                case MEDIUM -> score += 2;
                case HIGH -> score += 4;
                case IMMEDIATE -> score += 6;
            }
        }

        // Apply active rules
        for (PriorityRule rule : activeRules) {
            score += rule.getWeight();
        }

        return Math.max(0, score);
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findByActiveTrue();
    }
}