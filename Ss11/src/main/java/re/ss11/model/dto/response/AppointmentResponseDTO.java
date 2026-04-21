package re.ss11.model.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponseDTO {

    private Long id;

    // Thời gian hẹn
    private LocalDateTime appointmentTime;

    // Ghi chú
    private String note;

    // Trạng thái (Scheduled, Done, Cancelled)
    private String status;

    // Thông tin cơ bản của bác sĩ (không trả full object)
    private Long doctorId;
    private String doctorName;
}