package re.ss11.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss11.exception.DepartmentNotFoundException;
import re.ss11.exception.DuplicateResourceException;
import re.ss11.mapper.DoctorMapper;
import re.ss11.model.dto.request.DoctorCreateDTO;
import re.ss11.model.dto.response.DoctorResponseDTO;
import re.ss11.model.entity.Doctor;
import re.ss11.repository.DoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    // 1. Lấy danh sách toàn bộ bác sĩ
    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toDto)
                .toList();
    }

    // 2. Lấy chi tiết theo ID
    public DoctorResponseDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Không tìm thấy bác sĩ với id = " + id));

        return doctorMapper.toDto(doctor);
    }

    // 3. Thêm mới bác sĩ
    public Doctor createDoctor(DoctorCreateDTO req) {
        Doctor doctor = doctorMapper.toEntity(req);
        if (doctorRepository.existsByEmail(req.getEmail())) {
            throw new DuplicateResourceException("Email đã tồn tại");
        }

        if (doctorRepository.existsByPhone(req.getPhone())) {
            throw new DuplicateResourceException("Số điện thoại đã tồn tại");
        }

        return doctorRepository.save(doctor);
    }

    // 4. Cập nhật bác sĩ
    public Doctor updateDoctor(Long id, DoctorCreateDTO req) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Không tìm thấy bác sĩ với id = " + id));

        if (doctorRepository.existsByEmail(req.getEmail())) {
            throw new DuplicateResourceException("Email đã tồn tại");
        }

        if (doctorRepository.existsByPhone(req.getPhone())) {
            throw new DuplicateResourceException("Số điện thoại đã tồn tại");
        }

        // map dữ liệu từ DTO vào entity cũ
        doctorMapper.updateFromDto(req, doctor);

        return doctorRepository.save(doctor);
    }

    // 5. Xóa bác sĩ
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Không tìm thấy bác sĩ với id = " + id));

        doctorRepository.delete(doctor);
    }
}
