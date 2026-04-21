package re.ss11.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import re.ss11.model.dto.response.AppointmentResponseDTO;
import re.ss11.model.entity.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "doctor.id", target = "doctorId")
    @Mapping(source = "doctor.name", target = "doctorName")
    AppointmentResponseDTO toDto(Appointment appointment);
}
