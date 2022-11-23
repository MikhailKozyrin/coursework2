package kozyrin.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BigMoreRequestedException extends RuntimeException {

    public BigMoreRequestedException() {
        super();
    }

    public BigMoreRequestedException(String message) {
        super(message);
    }

    public BigMoreRequestedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BigMoreRequestedException(Throwable cause) {
        super(cause);
    }

    public BigMoreRequestedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
