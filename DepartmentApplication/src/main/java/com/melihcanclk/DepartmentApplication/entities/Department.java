package com.melihcanclk.DepartmentApplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Length(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    // @Email
    // @Positive
    // @Negative
    // @PositiveOrZero
    // @NegativeOrZero
    // @FutureOrPresent
    // @PastOrPresent
    private String name;
    private String address;
    private String code;
}
