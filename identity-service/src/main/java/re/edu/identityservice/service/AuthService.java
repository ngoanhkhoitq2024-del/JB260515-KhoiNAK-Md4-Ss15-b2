package re.edu.identityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import re.edu.identityservice.dto.TokenResponse;
import re.edu.identityservice.entity.RefreshToken;
import re.edu.identityservice.entity.User;
import re.edu.identityservice.repository.IUserRepository;
import re.edu.identityservice.utils.JwtUtils;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final RefreshTokenService refreshTokenService;

    @Transactional
    public TokenResponse login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("Username không tồn tại!")
                );

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Mật khẩu không chính xác!");
        }

        String accessToken = jwtUtils.generateAccessToken(user);

        String refreshToken = refreshTokenService
                .createRefreshToken(user)
                .getToken();

        return new TokenResponse(
                accessToken,
                refreshToken,
                "Bearer"
        );
    }
}
