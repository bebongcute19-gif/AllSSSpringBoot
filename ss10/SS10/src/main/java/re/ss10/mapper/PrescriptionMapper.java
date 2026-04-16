package re.ss10.mapper;

import org.mapstruct.Mapper;
import re.ss10.dto.response.PrescriptionResponse;
import re.ss10.entity.Prescription;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PatientMapper.class})

public interface PrescriptionMapper {
    PrescriptionResponse toResponse(re.ss10.entity.Prescription prescription);
    List<PrescriptionResponse> toResponseList(List<Prescription> list);
    Prescription toEntity(re.ss10.dto.request.PrescriptionAdd request);
}
