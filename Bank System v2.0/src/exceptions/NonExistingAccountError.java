package exceptions;

public class NonExistingAccountError extends RuntimeException {
    public NonExistingAccountError(String message) {
        super(message);
    }
}
