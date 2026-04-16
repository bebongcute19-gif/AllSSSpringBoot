package re.ss10.service;

import re.ss10.dto.response.AppoimentResponse;
import re.ss10.exception.NotFoundException;

import java.util.List;

public interface IAppointmentService {
    List<AppoimentResponse> getByDoctorId(Long id) throws NotFoundException;
}
