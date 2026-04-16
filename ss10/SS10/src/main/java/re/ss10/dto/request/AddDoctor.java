package re.ss10.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDoctor {
    @NotBlank(message = "Name không được để trống")
    private String name;
    @Email(message = "Không đúng định dạng email")
    @NotBlank(message = "Email không được để trống")
    private String email;
    @Pattern(regexp = "^(03|05|07|09|08)[0-9]{8}$", message = "Số điện thoại không hợp lệ")
    private String phone;
    private String address;
}

