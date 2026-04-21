package re.ss11.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss11.exception.DepartmentNotFoundException;
import re.ss11.mapper.PatientMapper;
import re.ss11.model.dto.response.PatientResponseDTO;
import re.ss11.model.entity.Patient;
import re.ss11.repository.PatientRepository;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientResponseDTO findPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Không tìm thấy bệnh nhân với id: " + id));
        return patientMapper.toDto(patient);
    }
}
