package re.ss12.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import re.ss12.validator.DepartmentNotFoundException;
import re.ss12.validator.DuplicateResourceException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodNotArgumentException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<?> handleDepartmentNotFoundException(DepartmentNotFoundException e) {
        Map<String, String> error = new HashMap<>();
        error.put("Lỗi tìm kiếm", e.getMessage());
        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<?> handleDuplicate(DuplicateResourceException e) {
        Map<String, String> error = new HashMap<>();
        error.put("Lỗi trùng lặp", e.getMessage());
        return new ResponseEntity<>(
                error,
                HttpStatus.CONFLICT
        );
    }
}
