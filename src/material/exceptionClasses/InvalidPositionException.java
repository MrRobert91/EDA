package material.exceptionClasses;

/**
 * Created by David R on 21/04/2016.
 */
public class InvalidPositionException extends RuntimeException {

    public InvalidPositionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPositionException() {

    }

    public InvalidPositionException(String message) {
        super(message);
    }

    public InvalidPositionException(Throwable cause) {
        super(cause);
    }

    public InvalidPositionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

