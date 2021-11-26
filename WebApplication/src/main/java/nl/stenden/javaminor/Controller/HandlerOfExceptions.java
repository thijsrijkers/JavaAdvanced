package nl.stenden.javaminor.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class HandlerOfExceptions {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ErrorMessage runTimeException(RuntimeException exception) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public class ErrorMessage {
        private HttpStatus error;

        public ErrorMessage(HttpStatus error) {
            this.error = error;
        }

        public HttpStatus getError() {
            return this.error;
        }
    }
}
