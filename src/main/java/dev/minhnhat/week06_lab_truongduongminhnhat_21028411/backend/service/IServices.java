package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface IServices<T>{
    void save(T t);
    void delete(Long id);
    void delete(T t);
    List<T> findAll();
    Optional<T> findById(Long id);
}
