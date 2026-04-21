package re.ss11.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import re.ss11.model.dto.response.PatientResponseDTO;
import re.ss11.model.entity.Patient;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-21T10:11:24+0700",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-9.4.1.jar, environment: Java 17.0.18 (Amazon.com Inc.)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientResponseDTO toDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientResponseDTO.PatientResponseDTOBuilder patientResponseDTO = PatientResponseDTO.builder();

        patientResponseDTO.id( patient.getId() );
        patientResponseDTO.name( patient.getName() );
        patientResponseDTO.email( patient.getEmail() );
        patientResponseDTO.phone( patient.getPhone() );
        patientResponseDTO.dob( patient.getDob() );
        patientResponseDTO.address( patient.getAddress() );

        return patientResponseDTO.build();
    }
}
