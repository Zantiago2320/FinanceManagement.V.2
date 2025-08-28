package com.app.FinanceManagement.Entity;

import jakarta.persistence.*;

import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false, unique = true)
    private Long idUser;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "role", nullable = false, length = 50)
    private String role;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @PrePersist
    private void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        if (this.createdAt == null) this.createdAt = now;
        this.updateAt = now;
        if (this.enabled == null) this.enabled = true;
    }

    @PreUpdate
    private void preUpdate() {
        this.updateAt = LocalDateTime.now();
    }
}

