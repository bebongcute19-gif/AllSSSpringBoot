package re.ss10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.ss10.dto.request.PrescriptionAdd;
import re.ss10.dto.response.ApiResponse;
import re.ss10.dto.response.DoctorResponse;
import re.ss10.dto.response.Meta;
import re.ss10.dto.response.PrescriptionResponse;
import re.ss10.exception.NotFoundException;
import re.ss10.mapper.PrescriptionMapper;
import re.ss10.service.IPrescriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PrescriptionController {
    private final IPrescriptionService prescriptionService;
    @GetMapping("/patient/{patientId}/prescriptions")
    public ResponseEntity<?> getByPatientId(@PathVariable  Long patientId) throws NotFoundException {
        List<PrescriptionResponse> data = prescriptionService.getByPatientId(patientId);
        Meta meta = new Meta(data.size(), 1, data.size());
        ApiResponse<List<PrescriptionResponse>> res = new ApiResponse<>(
                200,
                "Load data success",
                prescriptionService.getByPatientId(patientId),meta
        );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/patient/{patientId}/prescriptions")
    public ResponseEntity<?> create(
            @PathVariable  Long patientId,
            @RequestBody PrescriptionAdd request
    ) throws NotFoundException {
        return ResponseEntity.ok(new ApiResponse<>(
                201,
                "Create prescription success",
                prescriptionService.create(patientId,request),null
        ));
    }
}
