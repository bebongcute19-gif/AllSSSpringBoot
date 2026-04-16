package re.ss10.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.ss10.dto.request.AddDoctor;
import re.ss10.dto.request.DoctorUpdate;
import re.ss10.dto.response.ApiResponse;
import re.ss10.dto.response.DoctorResponse;
import re.ss10.dto.response.Meta;
import re.ss10.exception.BadRequestException;
import re.ss10.exception.DataConflictException;
import re.ss10.exception.NotFoundException;
import re.ss10.service.IDoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final IDoctorService doctorService;

    //1. lấy danh sách bác sĩ
    @GetMapping
    public  ResponseEntity<?>getAllDoctors() {
        List<DoctorResponse> data = doctorService.getAllDoctors();
        Meta meta = new Meta(data.size(), 1, data.size());
        ApiResponse<List<DoctorResponse>> res = new ApiResponse<>(
                200,
                "Lấy danh sách bác sĩ thành công",
                doctorService.getAllDoctors(),meta
        );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //2. lấy thông tin bác sĩ theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) throws NotFoundException {
        ApiResponse<DoctorResponse> res = new ApiResponse<>(
                200,
                "Lấy thông tin bác sĩ thành công",
                doctorService.getDoctorById(id),null
        );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //3. thêm mới bác sĩ
    @PostMapping
    public ResponseEntity<?> createDoctor(@RequestBody @Valid AddDoctor request) throws DataConflictException {
        ApiResponse<DoctorResponse> res = new ApiResponse<>(
                201,
                "Thêm mới bác sĩ thành công",
                doctorService.createDoctor(request),null
        );
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
        //4. cập nhật thông tin bác sĩ theo id
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable Long id,@Valid @RequestBody DoctorUpdate request) throws NotFoundException,DataConflictException, BadRequestException
    {
        ApiResponse<DoctorResponse> res = new ApiResponse<>(
                200,
                "Cập nhập thông tin bác sĩ thành công",
                doctorService.updateDoctor(request,id),null

        );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //5. Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) throws NotFoundException {
        doctorService.deleteDoctorById(id);
        ApiResponse<DoctorResponse> res = new ApiResponse<>(
                200,
                "Xóa thành công",
                null,
                null
        );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
