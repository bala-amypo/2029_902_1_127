package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "customer")
    private Set<Complaint> customerComplaints = new HashSet<>();

    @OneToMany(mappedBy = "assignedAgent")
    private Set<Complaint> assignedComplaints = new HashSet<>();

    public enum Role {
        CUSTOMER, AGENT, ADMIN
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public Set<Complaint> getCustomerComplaints() { return customerComplaints; }
    public void setCustomerComplaints(Set<Complaint> customerComplaints) { this.customerComplaints = customerComplaints; }

    public Set<Complaint> getAssignedComplaints() { return assignedComplaints; }
    public void setAssignedComplaints(Set<Complaint> assignedComplaints) { this.assignedComplaints = assignedComplaints; }
}