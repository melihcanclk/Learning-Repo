package com.melihcanclk.DepartmentApplication.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(
        name = "password_reset_token",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"token"}
        )
)
public class PasswordResetToken {
    // 10 minutes
    private static final int EXPIRATION_10_MINUTES = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;
    private Date expiryDate;
    private boolean verified = false;

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "FK_USER_PASSWORD_RESET_TOKEN"
            )
    )
    private User user;

    public PasswordResetToken(User user, String token) {
        this.user = user;
        this.token = token;

        this.expiryDate = calculateExpirationDate();
    }

    public PasswordResetToken(String token) {
        super();
        this.token = token;
        this.expiryDate = calculateExpirationDate();
    }

    private Date calculateExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, PasswordResetToken.EXPIRATION_10_MINUTES);
        return calendar.getTime();
    }
}
