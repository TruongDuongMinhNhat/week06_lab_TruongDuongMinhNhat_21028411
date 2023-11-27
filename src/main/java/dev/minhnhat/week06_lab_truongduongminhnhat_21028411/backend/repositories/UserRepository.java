package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.repositories;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmailAndPasswordHash(String email, String password);
}
