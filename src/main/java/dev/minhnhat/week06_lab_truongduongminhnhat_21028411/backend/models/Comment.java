package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Comment {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private Post postId;

    @ManyToOne
    @JoinColumn(name = "parentId", nullable = false)
    private Comment parentId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private boolean published;

    private LocalDateTime createdAt;

    private LocalDateTime publishedAt;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId", targetEntity = Comment.class)
    public List<Comment> comments;

    public Comment(Post postId, Comment parentId, User userId, String title, boolean published, LocalDateTime createdAt, LocalDateTime publishedAt, String content) {
        this.postId = postId;
        this.parentId = parentId;
        this.userId = userId;
        this.title = title;
        this.published = published;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }
}
