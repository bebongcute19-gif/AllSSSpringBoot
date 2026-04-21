package re.ss11.mapper;

import org.mapstruct.Mapper;
import re.ss11.model.dto.response.PatientResponseDTO;
import re.ss11.model.entity.Patient;

@Mapper(componentModel = "spring", uses = {PrescriptionMapper.class})
public interface PatientMapper {

    // Map Entity -> DTO
    PatientResponseDTO toDto(Patient patient);
}