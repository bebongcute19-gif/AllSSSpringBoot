package re.ss11.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import re.ss11.model.dto.response.PrescriptionResponseDTO;
import re.ss11.model.entity.Prescription;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {

    //    @Mapping(source = "patient.id", target = "patientId")
//    @Mapping(source = "patient.name", target = "patientName")
    PrescriptionResponseDTO toDto(Prescription prescription);
}
