package re.ss11.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import re.ss11.model.dto.response.AppointmentResponseDTO;
import re.ss11.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<?> getAppointmentByDoctorId(@RequestParam Long doctorId) {
        List<AppointmentResponseDTO> appointments = appointmentService.getAllAppointmentByDoctorId(doctorId);

        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}
