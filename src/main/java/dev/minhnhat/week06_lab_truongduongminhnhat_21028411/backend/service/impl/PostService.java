package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.Post;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.repositories.PostRepository;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IServices<Post> {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void save(Post post) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Post post) {

    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }
}
