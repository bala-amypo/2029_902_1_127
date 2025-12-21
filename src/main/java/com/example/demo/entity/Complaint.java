package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private int priorityScore;

    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;

    private LocalDateTime submittedOn;

    @ManyToOne
    private User user;

    // getters & setters
}
