package re.ss12.model.dto.request;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuppliesUpdateDTO {

    @Size(max = 255, message = "Tên vật tư tối đa 255 ký tự")
    private String name;

    @Size(max = 100, message = "Mã vật tư tối đa 100 ký tự")
    private String code;

    @PositiveOrZero(message = "Giá không được nhỏ hơn 0")
    private Double price;

    @Size(max = 500, message = "Mô tả tối đa 500 ký tự")
    private String description;
}