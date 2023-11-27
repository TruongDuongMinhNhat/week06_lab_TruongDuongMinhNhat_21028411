package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.User;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.repositories.UserRepository;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IServices<User> {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> checkLogin(String email, String password) {
        return userRepository.findUserByEmailAndPasswordHash(email, password);
    }
}
