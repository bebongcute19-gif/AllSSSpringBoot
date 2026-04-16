package re.ss10.mapper;

import org.mapstruct.Mapper;
import re.ss10.dto.response.AppoimentResponse;
import re.ss10.entity.Appoiment;

import java.util.List;

@Mapper(componentModel = "spring"
        ,uses = {DoctorMapper.class, PatientMapper.class}
)
public interface AppointmentMapper {
    AppoimentResponse toResponse(Appoiment appoiment);
    List<AppoimentResponse> toResponseList(List<Appoiment> list);
}
