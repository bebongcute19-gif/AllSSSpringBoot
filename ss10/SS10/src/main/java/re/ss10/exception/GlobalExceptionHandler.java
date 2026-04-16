package re.ss10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import re.ss10.dto.response.ErrorResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Lỗi validate @Valid (DTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<Object>> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err ->
                errors.put(err.getField(), err.getDefaultMessage())
        );

        return buildResponse(400, "Validation failed", errors, HttpStatus.BAD_REQUEST);
    }

    // 2. Sai kiểu dữ liệu (vd: id truyền chữ)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse<String>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return buildResponse(400, "Invalid parameter",
                "Giá trị không hợp lệ cho: " + ex.getName(),
                HttpStatus.BAD_REQUEST);
    }

    // 3. Not Found
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse<String>> handleNotFound(NotFoundException ex) {
        return buildResponse(404, "Not Found", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // 4. Conflict (trùng email, phone...)
    @ExceptionHandler(DataConflictException.class)
    public ResponseEntity<ErrorResponse<String>> handleConflict(DataConflictException ex) {
        return buildResponse(409, "Data Conflict", ex.getMessage(), HttpStatus.CONFLICT);
    }

    // 5. Bad Request (tự throw)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse<String>> handleBadRequest(BadRequestException ex) {
        return buildResponse(400, "Bad Request", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // 6. Các lỗi Illegal (null, sai logic...)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse<String>> handleIllegal(IllegalArgumentException ex) {
        return buildResponse(400, "Illegal Argument", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // 7. Lỗi chưa bắt (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse<String>> handleAll(Exception ex) {
        return buildResponse(500, "Server Error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ================= COMMON BUILDER =================
    private <T> ResponseEntity<ErrorResponse<T>> buildResponse(
            int code, String error, T message, HttpStatus status) {

        ErrorResponse<T> res = new ErrorResponse<>(code, error, message);
        return new ResponseEntity<>(res, status);
    }
}
