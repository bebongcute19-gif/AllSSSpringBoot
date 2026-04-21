package re.ss12.model.dto.request;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuppliesCreateDTO {

    @NotBlank(message = "Tên vật tư không được để trống")
    @Size(max = 255, message = "Tên vật tư tối đa 255 ký tự")
    private String name;

    @NotBlank(message = "Mã vật tư không được để trống")
    @Size(max = 100, message = "Mã vật tư tối đa 100 ký tự")
    private String code;

    @NotNull(message = "Giá không được để trống")
    @PositiveOrZero(message = "Giá không được nhỏ hơn 0")
    private Double price;

    @Size(max = 500, message = "Mô tả tối đa 500 ký tự")
    private String description;
}