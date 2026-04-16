package re.ss10.dto.request;

import lombok.Getter;
import lombok.Setter;
import re.ss10.dto.response.PatientSummary;
@Getter
@Setter
public class PrescriptionAdd {
    private String medicine;
    private String dosage;
}
