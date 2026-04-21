package re.ss11.mapper;

import org.mapstruct.*;
import re.ss11.model.dto.request.DoctorCreateDTO;
import re.ss11.model.dto.response.DoctorResponseDTO;
import re.ss11.model.entity.Doctor;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(source = "dob", target = "dob")
    Doctor toEntity(DoctorCreateDTO dto);

    DoctorResponseDTO toDto(Doctor doctor);

    void updateFromDto(DoctorCreateDTO dto, @MappingTarget Doctor doctor);
}
