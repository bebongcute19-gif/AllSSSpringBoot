package re.ss10.mapper;

import org.mapstruct.Mapper;
import re.ss10.dto.response.DoctorSummary;
import re.ss10.entity.Doctors;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorSummary toSummary(Doctors doctor);
}
