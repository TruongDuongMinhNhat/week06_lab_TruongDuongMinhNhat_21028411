package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Post")
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Post {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User authorId;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NonNull
    private Post parentId;

    @Column(length = 75, nullable = false)
    @NonNull
    private String title;

    @Column(length = 100, nullable = false)
    @NonNull
    private String metaTitle;

    @Column(columnDefinition = "TINYTEXT", nullable = false)
    @NonNull
    private String summary;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private boolean publised;

    @Column(nullable = false)
    @NonNull
    private LocalDate createdAt;

    @Column(nullable = false)
    @NonNull
    private LocalDate updateAt;

    @Column(nullable = false)
    @NonNull
    private LocalDate publishedAt;

    @Column(nullable = false)
    @NonNull
    private String content;
}
