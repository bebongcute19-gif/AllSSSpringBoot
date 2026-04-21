package re.ss11.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.ss11.model.dto.request.DoctorCreateDTO;
import re.ss11.model.dto.response.DoctorResponseDTO;
import re.ss11.model.entity.Doctor;
import re.ss11.service.DoctorService;

import java.util.List;

@Slf4j // [MỚI] Sử dụng Slf4j từ Lombok để ghi log
@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    // 1. Lấy danh sách tất cả bác sĩ
    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
        log.info("Request nhận được: Lấy danh sách tất cả bác sĩ"); // [GHI LOG]
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    // 2. Lấy chi tiết bác sĩ theo ID
    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable Long id) {
        log.info("Request nhận được: Tìm kiếm bác sĩ với ID: {}", id); // [GHI LOG]
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    // 3. Thêm mới bác sĩ
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody DoctorCreateDTO dto) {
        log.info("Request nhận được: Tạo mới bác sĩ với tên: {}", dto.getName()); // [GHI LOG]
        return ResponseEntity.ok(doctorService.createDoctor(dto));
    }

    // 4. Cập nhật bác sĩ
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Long id,
            @Valid @RequestBody DoctorCreateDTO dto
    ) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, dto));
    }

    // 5. Xóa bác sĩ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        log.warn("Request nhận được: Xóa bác sĩ có ID: {}", id); // [GHI LOG mức WARN]
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}