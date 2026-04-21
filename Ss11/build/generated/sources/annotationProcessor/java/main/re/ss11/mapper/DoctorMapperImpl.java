package re.ss11.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import re.ss11.model.dto.request.DoctorCreateDTO;
import re.ss11.model.dto.response.DoctorResponseDTO;
import re.ss11.model.entity.Doctor;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-21T10:11:23+0700",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-9.4.1.jar, environment: Java 17.0.18 (Amazon.com Inc.)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public Doctor toEntity(DoctorCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Doctor.DoctorBuilder doctor = Doctor.builder();

        doctor.dob( dto.getDob() );
        doctor.name( dto.getName() );
        doctor.email( dto.getEmail() );
        doctor.phone( dto.getPhone() );
        doctor.specialization( dto.getSpecialization() );
        doctor.experienceYears( dto.getExperienceYears() );
        doctor.address( dto.getAddress() );

        return doctor.build();
    }

    @Override
    public DoctorResponseDTO toDto(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorResponseDTO.DoctorResponseDTOBuilder doctorResponseDTO = DoctorResponseDTO.builder();

        doctorResponseDTO.id( doctor.getId() );
        doctorResponseDTO.name( doctor.getName() );
        doctorResponseDTO.email( doctor.getEmail() );
        doctorResponseDTO.phone( doctor.getPhone() );
        doctorResponseDTO.specialization( doctor.getSpecialization() );
        doctorResponseDTO.experienceYears( doctor.getExperienceYears() );
        doctorResponseDTO.dob( doctor.getDob() );
        doctorResponseDTO.address( doctor.getAddress() );
        doctorResponseDTO.active( doctor.getActive() );

        return doctorResponseDTO.build();
    }

    @Override
    public void updateFromDto(DoctorCreateDTO dto, Doctor doctor) {
        if ( dto == null ) {
            return;
        }

        doctor.setName( dto.getName() );
        doctor.setEmail( dto.getEmail() );
        doctor.setPhone( dto.getPhone() );
        doctor.setSpecialization( dto.getSpecialization() );
        doctor.setExperienceYears( dto.getExperienceYears() );
        doctor.setDob( dto.getDob() );
        doctor.setAddress( dto.getAddress() );
    }
}
