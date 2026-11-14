package re.edu.identityservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import re.edu.identityservice.dto.LoginRequest;
import re.edu.identityservice.dto.TokenResponse;
import re.edu.identityservice.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(
            @RequestBody LoginRequest request
    ) {

        TokenResponse response = authService.login(
                request.username(),
                request.password()
        );

        return ResponseEntity.ok(response);
    }
}

