package re.ss10.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppoimentResponse {
    private Long id;
    private LocalDateTime appoimentDate;
    private DoctorSummary doctor;
    private PatientSummary patient;
}
