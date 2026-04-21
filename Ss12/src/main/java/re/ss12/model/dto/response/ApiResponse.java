package re.ss12.model.dto.response;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {

    private T data;              // dữ liệu trả về
    private String info;         // message
    private int status;          // HTTP status
    private LocalDateTime time;  // thời gian response
}