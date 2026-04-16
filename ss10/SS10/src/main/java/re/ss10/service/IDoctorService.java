package re.ss10.service;

import org.aspectj.weaver.ast.Not;
import re.ss10.dto.request.AddDoctor;
import re.ss10.dto.request.DoctorUpdate;
import re.ss10.dto.response.DoctorResponse;
import re.ss10.exception.BadRequestException;
import re.ss10.exception.DataConflictException;
import re.ss10.exception.NotFoundException;

import java.util.List;

public interface IDoctorService {
    List<DoctorResponse> getAllDoctors();
    DoctorResponse getDoctorById(Long id) throws NotFoundException;
    DoctorResponse createDoctor(AddDoctor request) throws DataConflictException;
    DoctorResponse updateDoctor(DoctorUpdate request, Long id)throws NotFoundException, DataConflictException, BadRequestException;
    void deleteDoctorById(Long id) throws NotFoundException;
}
