package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Table(name = "post_comment")
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Comment {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @Column(nullable = false)
    @NonNull
    private Post postID;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NonNull
    private Comment parentID;

    @ManyToOne
    @Column(nullable = false)
    @NonNull
    private User userID;

    @Column(nullable = false)
    private long title;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private boolean published;

    @Column(nullable = false)
    @NonNull
    private LocalDate createdAt;

    @Column(nullable = false)
    @NonNull
    private LocalDate publishedAt;

    @Column(nullable = false)
    @NonNull
    private String content;
}
