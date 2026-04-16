package re.ss10.service;

import re.ss10.dto.request.PrescriptionAdd;
import re.ss10.dto.response.PrescriptionResponse;
import re.ss10.entity.Prescription;
import re.ss10.exception.NotFoundException;

import java.util.List;

public interface IPrescriptionService {
    List<PrescriptionResponse> getByPatientId(Long patientId) throws NotFoundException;
    PrescriptionResponse create(Long patientId, PrescriptionAdd request) throws NotFoundException;
}
