package re.ss10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.ss10.dto.response.ApiResponse;
import re.ss10.dto.response.AppoimentResponse;
import re.ss10.dto.response.Meta;
import re.ss10.dto.response.PrescriptionResponse;
import re.ss10.exception.NotFoundException;
import re.ss10.service.IAppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AppointmentController {
    private final IAppointmentService appointmentService;
    @GetMapping("/doctor/{doctorId}/appointments")
    public ResponseEntity<?> getByDoctorId(@PathVariable Long doctorId) throws NotFoundException {
        List<AppoimentResponse> data = appointmentService.getByDoctorId(doctorId);
        Meta meta = new Meta(data.size(), 1, data.size());
        ApiResponse<List<AppoimentResponse>> res = new ApiResponse<>(
                200,
                "Load data success!!",
                appointmentService.getByDoctorId(doctorId),meta
        );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
