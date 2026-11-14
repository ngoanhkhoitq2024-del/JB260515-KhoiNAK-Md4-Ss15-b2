package re.edu.identityservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import re.edu.identityservice.entity.User;
import re.edu.identityservice.repository.IUserRepository;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData() {
        return args -> {

            if (!userRepository.existsByUsername("student")) {
                User user = new User(
                        "student",
                        passwordEncoder.encode("123456"),
                        "STUDENT"
                );
                userRepository.save(user);
            }
        };
    }
}
