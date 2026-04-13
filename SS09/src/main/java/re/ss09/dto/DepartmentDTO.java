package re.ss09.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DepartmentDTO {
    @NotBlank(message = "Tên phòng ban không được để trống")
    @Size(min= 5 , max = 50, message = "Tên phòng ban phải có độ dài từ 5 đến 50 ký tự")
    private String name;
    @Size(max = 100, message = "Mô tả không được vượt quá 100 ký tự")
    private String description;
}
