package re.ss12.model.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PageResponse {
    private Integer page;

    private Integer size;

    private Long totalElements;

    private Integer totalPages;
}
