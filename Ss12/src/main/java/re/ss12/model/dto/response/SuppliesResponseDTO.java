package re.ss12.model.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuppliesResponseDTO {
    private Long id;
    private String name;
    private String code;
    private Integer quantity;
    private Double price;
    private String description;
}
