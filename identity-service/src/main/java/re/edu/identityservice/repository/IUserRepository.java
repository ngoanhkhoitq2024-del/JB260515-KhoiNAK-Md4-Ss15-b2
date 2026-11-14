package re.edu.identityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.identityservice.entity.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}