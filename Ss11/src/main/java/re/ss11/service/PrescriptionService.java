package re.ss11.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss11.exception.DepartmentNotFoundException;
import re.ss11.model.dto.response.PrescriptionResponseDTO;
import re.ss11.repository.PatientRepository;
import re.ss11.repository.PrescriptionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final PatientRepository patientRepository;

    public PrescriptionResponseDTO getPrescriptionByPatientId(Long patientId, Long prescriptionId){

        // 1. Check patient tồn tại
        if (!patientRepository.existsById(patientId)) {
            throw new DepartmentNotFoundException("Không tìm thấy bệnh nhân với id: " + patientId);
        }

        // 2. Lấy đơn thuốc (đã trả thẳng DTO)
        PrescriptionResponseDTO dto =
                prescriptionRepository.findByIdAndPatientId(prescriptionId, patientId);

        // 3. Check nếu không có
        if (dto == null) {
            throw new DepartmentNotFoundException("Đơn thuốc không tồn tại hoặc không thuộc bệnh nhân này");
        }

        return dto;
    }
}