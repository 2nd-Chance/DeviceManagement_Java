package device;

public class UndefinedDeviceClassException extends RuntimeException {

    public UndefinedDeviceClassException() {
        super();
    }

    public UndefinedDeviceClassException(final String message) {
        super(message);
    }

    public UndefinedDeviceClassException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UndefinedDeviceClassException(final Throwable cause) {
        super(cause);
    }

    protected UndefinedDeviceClassException(final String message, final Throwable cause,
        final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
