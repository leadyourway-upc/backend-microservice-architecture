package pe.edu.leadyourway.authmicroservice.application.exception;

public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
