package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private User authorID;

    @ManyToOne
    @JoinColumn(name = "parentId", nullable = false)
    private Post parentId;

    @Column(length = 75, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String metaTitle;

    @Column(columnDefinition = "TINYTEXT", nullable = false)
    private String summary;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private boolean published;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime publishedAt;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @OneToMany(mappedBy = "parentId", cascade = CascadeType.ALL, targetEntity = Post.class)
    public List<Post> posts;

    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, targetEntity = Comment.class)
    public List<Comment> comments;

    public Post(User authorID, Post parentId, String title, String metaTitle, String summary, boolean published, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime publishedAt, String content) {
        this.authorID = authorID;
        this.parentId = parentId;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }
}
