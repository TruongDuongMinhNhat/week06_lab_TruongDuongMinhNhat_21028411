package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.repositories;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.Post;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByPublishedAtIsTrueOrderByUpdatedAtDesc();
    List<Post> findAllByPublishedAtIsTrueOrderByUpdatedAtAsc();
    List<Post> findAllByAuthorIdAndParentIdIsNull(User authorId);
}
