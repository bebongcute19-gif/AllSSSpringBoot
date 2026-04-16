package re.ss10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss10.dto.request.PrescriptionAdd;
import re.ss10.dto.response.PrescriptionResponse;
import re.ss10.entity.Patients;
import re.ss10.entity.Prescription;
import re.ss10.exception.NotFoundException;
import re.ss10.mapper.PrescriptionMapper;
import re.ss10.repository.IPatientRepository;
import re.ss10.repository.IPrescriptionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements IPrescriptionService {
    private final IPrescriptionRepository prescriptionRepository;
    private final PrescriptionMapper prescriptionMapper;
    private final IPatientRepository patientRepository;
    @Override
    public List<PrescriptionResponse> getByPatientId(Long patientId) throws NotFoundException {
        Patients patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new NotFoundException("Bệnh nhân không tồn tại!"));
        List<Prescription> prescriptions = prescriptionRepository.findByPatientId(patientId);
        return prescriptionMapper.toResponseList(prescriptions);
    }

    @Override
    public PrescriptionResponse create(Long patientId, PrescriptionAdd request) throws NotFoundException {
        Patients patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new NotFoundException("Bệnh nhân không tồn tại!"));
        Prescription prescription = prescriptionMapper.toEntity(request);
        prescription.setPatient(patient);
        Prescription save = prescriptionRepository.save(prescription);
        return prescriptionMapper.toResponse(save);
    }
}
