package re.ss11.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss11.exception.DepartmentNotFoundException;

import re.ss11.model.dto.response.AppointmentResponseDTO;
import re.ss11.repository.AppointmentRepository;
import re.ss11.repository.DoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    private final DoctorRepository doctorRepository;

    public List<AppointmentResponseDTO> getAllAppointmentByDoctorId(Long doctorId) {

        // 1. Check tồn tại doctor
        if (!doctorRepository.existsById(doctorId)) {
            throw new DepartmentNotFoundException("Không tìm thấy bác sĩ với id: " + doctorId);
        }

        // 2. Lấy danh sách lịch hẹn
        return appointmentRepository.findAllByDoctorId(doctorId);
    }
}
