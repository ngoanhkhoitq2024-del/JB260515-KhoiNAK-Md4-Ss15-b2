package re.edu.identityservice.dto;

public record TokenResponse(
        String accessToken,
        String refreshToken,
        String tokenType
) {
}
