package re.ss10.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"id", "medicine", "dosage", "patient"})
public class PrescriptionResponse {
    private Long id;
    private String medicine;
    private String dosage;
    private PatientSummary patient;
}
