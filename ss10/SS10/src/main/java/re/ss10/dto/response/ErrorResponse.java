package re.ss10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse<T> {
    private int status;
    private String message;
    private T details;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
