package re.ss09.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {

    private String status;   // SUCCESS / FAIL
    private String message;
    private T data;
}