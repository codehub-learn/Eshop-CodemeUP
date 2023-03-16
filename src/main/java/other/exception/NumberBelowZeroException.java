package other.exception;

public class NumberBelowZeroException extends RuntimeException {
    public NumberBelowZeroException(String message) {
        super(message);
    }
}
