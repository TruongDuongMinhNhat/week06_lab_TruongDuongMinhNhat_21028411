package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "User")
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    @NonNull
    private String firstName;

    @Column(length = 50, nullable = false)
    @NonNull
    private String middleName;

    @Column(length = 50, nullable = false)
    @NonNull
    private String lastName;

    @Column(length = 15, nullable = false)
    @NonNull
    private String mobile;

    @Column(length = 50, nullable = false)
    @NonNull
    private String email;

    @Column(length = 32, nullable = false)
    @NonNull
    private String passwordHash;

    private LocalDate registerdAt;

    private LocalDate lastLogin;

    @Column(columnDefinition = "TINYINT", nullable = false)
    @NonNull
    private String intro;

    @Column(columnDefinition = "TEXT", nullable = false)
    @NonNull
    private String text;
}
