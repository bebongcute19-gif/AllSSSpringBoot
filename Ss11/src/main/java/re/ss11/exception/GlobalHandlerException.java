package re.ss11.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j // [MỚI] Ghi log lỗi hệ thống
@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodNotArgumentException(MethodArgumentNotValidException e) {
        log.error("Lỗi Validation: {}", e.getMessage()); // [GHI LOG LỖI]
        Map<String, String> errors = new HashMap<>();
        e.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<?> handleDepartmentNotFoundException(DepartmentNotFoundException e) {
        log.error("Không tìm thấy phòng ban: {}", e.getMessage()); // [GHI LOG LỖI]
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<?> handleDuplicate(DuplicateResourceException e) {
        log.error("Lỗi trùng lặp tài nguyên: {}", e.getMessage()); // [GHI LOG LỖI]
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
