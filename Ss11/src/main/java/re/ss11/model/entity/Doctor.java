package re.ss11.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên bác sĩ (bắt buộc)
    @Column(nullable = false, length = 100)
    private String name;

    // Email (không trùng, bắt buộc)
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    // Số điện thoại (không trùng, bắt buộc)
    @Column(nullable = false, unique = true, length = 15)
    private String phone;

    // Chuyên khoa (bắt buộc)
    @Column(nullable = false, length = 100)
    private String specialization;

    // Số năm kinh nghiệm
    @Column(name = "experience_years", nullable = false)
    private Integer experienceYears;

    // Ngày sinh
    @Column(name = "date_of_birth" ,nullable = false)
    private LocalDate dob;

    // Địa chỉ
    @Column(length = 255)
    private String address;

    // Trạng thái làm việc
    @Builder.Default
    @Column(nullable = false)
    private Boolean active = true;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointment;
}