package re.ss10.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;
    private Meta meta;
    private final LocalDateTime  timestamp = LocalDateTime.now(); // thời gian trả về
}