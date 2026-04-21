package re.ss11.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import re.ss11.model.dto.response.AppointmentResponseDTO;
import re.ss11.model.entity.Appointment;
import re.ss11.model.entity.Doctor;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-21T10:11:24+0700",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-9.4.1.jar, environment: Java 17.0.18 (Amazon.com Inc.)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentResponseDTO toDto(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentResponseDTO.AppointmentResponseDTOBuilder appointmentResponseDTO = AppointmentResponseDTO.builder();

        appointmentResponseDTO.doctorId( appointmentDoctorId( appointment ) );
        appointmentResponseDTO.doctorName( appointmentDoctorName( appointment ) );
        appointmentResponseDTO.id( appointment.getId() );
        appointmentResponseDTO.appointmentTime( appointment.getAppointmentTime() );
        appointmentResponseDTO.note( appointment.getNote() );
        appointmentResponseDTO.status( appointment.getStatus() );

        return appointmentResponseDTO.build();
    }

    private Long appointmentDoctorId(Appointment appointment) {
        Doctor doctor = appointment.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        return doctor.getId();
    }

    private String appointmentDoctorName(Appointment appointment) {
        Doctor doctor = appointment.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        return doctor.getName();
    }
}
