package re.ss11.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "prescriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ngày kê đơn
    @Column(nullable = false)
    private LocalDate prescriptionDate;

    // Nội dung đơn thuốc
    @Column(nullable = false, length = 500)
    private String description;

    // Quan hệ nhiều - 1 với Patient
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}