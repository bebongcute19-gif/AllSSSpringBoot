package re.ss11.model.dto.response;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponseDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String specialization;

    private Integer experienceYears;

    private LocalDate dob;

    private String address;

    private Boolean active;
}