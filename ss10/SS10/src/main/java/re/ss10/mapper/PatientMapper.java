package re.ss10.mapper;

import org.mapstruct.Mapper;
import re.ss10.dto.response.PatientSummary;
import re.ss10.entity.Patients;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientSummary toPatientSummary(Patients patient);
}
