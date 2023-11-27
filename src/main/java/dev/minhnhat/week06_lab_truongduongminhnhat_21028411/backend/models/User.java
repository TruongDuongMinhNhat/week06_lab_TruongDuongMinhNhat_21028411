package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String middleName;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 15, nullable = false)
    private String mobile;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 32, nullable = false)
    private String passwordHash;
    private LocalDate registeredAt;
    private LocalDate lastLogin;
    @Column(columnDefinition = "TINYTEXT", nullable = false)
    private String intro;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String profile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorID", targetEntity = Post.class)
    public List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", targetEntity = Comment.class)
    public List<Comment> comments;

    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, LocalDate registeredAt, LocalDate lastLogin, String intro, String profile) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registeredAt = registeredAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
    }
}
