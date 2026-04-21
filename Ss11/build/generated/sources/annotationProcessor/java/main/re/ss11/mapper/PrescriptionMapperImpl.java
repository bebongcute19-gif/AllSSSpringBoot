package re.ss11.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import re.ss11.model.dto.response.PrescriptionResponseDTO;
import re.ss11.model.entity.Prescription;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-21T10:11:24+0700",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-9.4.1.jar, environment: Java 17.0.18 (Amazon.com Inc.)"
)
@Component
public class PrescriptionMapperImpl implements PrescriptionMapper {

    @Override
    public PrescriptionResponseDTO toDto(Prescription prescription) {
        if ( prescription == null ) {
            return null;
        }

        PrescriptionResponseDTO.PrescriptionResponseDTOBuilder prescriptionResponseDTO = PrescriptionResponseDTO.builder();

        prescriptionResponseDTO.id( prescription.getId() );
        prescriptionResponseDTO.prescriptionDate( prescription.getPrescriptionDate() );
        prescriptionResponseDTO.description( prescription.getDescription() );

        return prescriptionResponseDTO.build();
    }
}
