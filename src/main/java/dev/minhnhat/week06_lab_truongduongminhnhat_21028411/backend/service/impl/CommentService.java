package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.Comment;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.Post;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.repositories.CommentRepository;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements IServices<Comment> {

    @Autowired
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findListCommentByPostId(Post postId) {
        return commentRepository.findAllByPostIdAndParentIdNullOrderByPublishedAtDesc(postId);
    }

    public List<Comment> findSubComments(Comment comment) {
        return commentRepository.findAllByParentId(comment);
    }
}
