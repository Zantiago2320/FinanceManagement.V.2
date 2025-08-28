package com.app.FinanceManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Category", nullable = false, unique = true)
    private Long idCategory;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;
}