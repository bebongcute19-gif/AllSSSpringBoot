package re.ss11.model.dto.response;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrescriptionResponseDTO {

    private Long id;

    // Ngày kê đơn
    private LocalDate prescriptionDate;

    // Nội dung đơn thuốc
    private String description;

    // Thông tin bệnh nhân (rút gọn)
    private Long patientId;
    private String patientName;
}