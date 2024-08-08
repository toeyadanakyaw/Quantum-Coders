package com.announce.AcknowledgeHub_SpringBoot.entity;

import com.announce.AcknowledgeHub_SpringBoot.model.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "ph_number")
    private String ph_number;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "status")
    private boolean status;

    @Column(name = "department_name")
    private String department_name;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "group_id")
    private int group_id;
}
