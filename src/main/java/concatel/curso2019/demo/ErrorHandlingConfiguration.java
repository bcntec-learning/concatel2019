package concatel.curso2019.demo;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.dozer.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
@ControllerAdvice
public class ErrorHandlingConfiguration {

    @ExceptionHandler({NoSuchElementException.class, EntityNotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlingNotFound(Exception e) {
        log.error(e.getMessage(), e);
        return ErrorResponse.builder().code("404").message(e.getMessage()).build();
    }

    @ExceptionHandler({MappingException.class, InvocationTargetException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> handlingUnknown(Exception e) {
        log.error(e.getMessage(), e);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (e instanceof MappingException) {
            if (e.getCause().getCause() instanceof EntityNotFoundException) {
                status = HttpStatus.NOT_FOUND;
            }
        }

        return ResponseEntity.status(status).body(
                ErrorResponse.builder().code(status.toString()).message(e.getMessage()).build()
        );

   
    }

    @Builder
    @Data
    public static class ErrorResponse {
        String code;
        String message;
    }
}
