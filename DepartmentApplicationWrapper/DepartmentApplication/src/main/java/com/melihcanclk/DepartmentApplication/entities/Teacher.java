package com.melihcanclk.DepartmentApplication.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String name;
    private String surname;

    //@OneToMany(
    //        cascade = CascadeType.ALL,
    //        fetch = FetchType.LAZY
    //)
    //@JoinColumn(
    //        name = "teacher_id",
    //       referencedColumnName = "id"
    //)
    //private List<Course> courses;
}
