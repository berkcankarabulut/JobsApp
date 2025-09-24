package com.Project.App.JobsApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "users")
@Entity
public class User {
    @Id
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
}
