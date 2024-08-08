package com.announce.AcknowledgeHub_SpringBoot.entity;

import com.announce.AcknowledgeHub_SpringBoot.model.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "user") // Use a different table name if 'user' is a reserved keyword in your DBMS
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "status")
    private boolean status;

    @Column(name = "department_name")
    private String department_name;

    @Column(name = "company_name")
    private String company_name;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Adjust based on your business logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Adjust based on your business logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Adjust based on your business logic
    }

    @Override
    public boolean isEnabled() {
        return status;
    }
}
