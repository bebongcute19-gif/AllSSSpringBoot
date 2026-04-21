package re.ss11.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Thời gian hẹn
    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    // Ghi chú
    @Column(length = 255)
    private String note;

    // Trạng thái (Scheduled, Done, Cancelled...)
    @Column(nullable = false, length = 50)
    private String status;

    // Quan hệ nhiều - 1 với Doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}