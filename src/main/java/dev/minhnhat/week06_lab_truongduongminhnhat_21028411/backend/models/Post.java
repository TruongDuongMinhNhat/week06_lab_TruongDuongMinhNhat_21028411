package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity @Table(name = "post")
@Getter @Setter @NoArgsConstructor
public class Post {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User authorId;
    @ManyToOne
    @JoinColumn(nullable = true)
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId")
    private List<Post> posts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private List<Comment> comments;

    public Post(User authorId, Post parentId, String title, String metaTitle, String summary, boolean published, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime publishedAt, String content) {
        this.authorId = authorId;
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

    public String getPostIdAndTitle() {
        return this.id + " - " + this.title;
    }
}
