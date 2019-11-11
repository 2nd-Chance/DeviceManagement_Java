package device;

public class InvalidLevelException extends RuntimeException {

    public InvalidLevelException() {
        super();
    }

    public InvalidLevelException(final String message) {
        super(message);
    }

    public InvalidLevelException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidLevelException(final Throwable cause) {
        super(cause);
    }

    protected InvalidLevelException(final String message, final Throwable cause,
        final boolean enableSuppression,
        final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
