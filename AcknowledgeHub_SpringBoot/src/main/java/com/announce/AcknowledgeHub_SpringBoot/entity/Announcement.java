package com.announce.AcknowledgeHub_SpringBoot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "staff")
public class Announcement {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private int id;

     @Column(name = "title")
     private String title;

     @Column(name = "content")
     private String content;

     @Temporal(TemporalType.TIMESTAMP)
     @Column(name = "created_at", updatable = false)
     private Date created_at;

     @PrePersist
     protected void onCreate(){
          this.created_at = new Date();
     }

     @Column(name = "document")
     private String document;

     @Column(name = "scheduled_date")
     private Date scheduled_date;

     @ManyToMany
     @JoinTable(
             name = "announcement_group",
             joinColumns = @JoinColumn(name = "announcement_id"),
             inverseJoinColumns = @JoinColumn(name = "group_id")
     )
     private List<Group> groups;

     @ManyToOne
     @JoinColumn(name = "user_id")
     private User user;
}
