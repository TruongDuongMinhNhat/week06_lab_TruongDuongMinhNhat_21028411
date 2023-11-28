package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.repositories;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.Comment;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostIdAndParentIdNullOrderByPublishedAtDesc(Post post);
    List<Comment> findAllByParentId(Comment comment);
}
