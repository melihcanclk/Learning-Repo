package com.melihcanclk.DepartmentApplication.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @jakarta.persistence.Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "surname",
                column = @jakarta.persistence.Column(name = "guardian_surname")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @jakarta.persistence.Column(name = "guardian_mobile")
        )
})
public class Guardian {
    private String name;
    private String surname;
    private String mobile;
}

