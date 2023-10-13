package com.melihcanclk.DepartmentApplication.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "USER_TABLE"
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String email;

    @Column(
            nullable = false,
            length = 60
    )
    private String password;
    private String role;
    private boolean enabled = false;
}
