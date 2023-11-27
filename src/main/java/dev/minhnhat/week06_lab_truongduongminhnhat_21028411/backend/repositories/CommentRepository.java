package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.repositories;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
