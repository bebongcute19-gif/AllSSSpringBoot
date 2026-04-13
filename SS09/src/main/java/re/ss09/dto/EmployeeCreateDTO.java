package re.ss09.dto;

import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeCreateDTO {
    @NotBlank(message = "Tên nhân viên không được để trống")
    private String fullName;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    private String email;

    @Pattern(regexp = "^(03|05|07|09|08)[0-9]{8}$", message = "Số điện thoại không hợp lệ")
    private String phone;
    @Min(value = 5000000, message = "Lương phải lớn hơn hoặc bằng 5 triệu")
    private Long salary;
    @NotNull(message = "Phòng ban không được để trống")
    private Long departmentId;
}
