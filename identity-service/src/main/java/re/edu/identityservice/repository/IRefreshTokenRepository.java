package re.edu.identityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.edu.identityservice.entity.RefreshToken;

import java.util.Optional;

public interface IRefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
}