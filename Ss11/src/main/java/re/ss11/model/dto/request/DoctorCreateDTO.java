package re.ss11.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorCreateDTO {

    // Tên bác sĩ (bắt buộc)
    @NotBlank(message = "Tên không được để trống")
    @Size(max = 100, message = "Tên tối đa 100 ký tự")
    private String name;

    // Email (bắt buộc + đúng định dạng)
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Size(max = 150, message = "Email tối đa 150 ký tự")
    private String email;

    // SĐT (bắt buộc + regex cơ bản)
    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(0|\\+84)[0-9]{9}$", message = "Số điện thoại không hợp lệ")
    private String phone;

    // Chuyên khoa
    @NotBlank(message = "Chuyên khoa không được để trống")
    @Size(max = 100, message = "Chuyên khoa tối đa 100 ký tự")
    private String specialization;

    // Số năm kinh nghiệm
    @NotNull(message = "Kinh nghiệm không được để trống")
    @Min(value = 0, message = "Khinh nghiệm không được nhỏ hơn 0")
    @Max(value = 60, message = "Kinh nghiệm không hợp lệ")
    private Integer experienceYears;

    // Ngày sinh
    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là quá khứ")
    private LocalDate dob;

    // Địa chỉ (không bắt buộc)
    @Size(max = 255, message = "Địa chỉ tối đa 255 ký tự")
    private String address;
}