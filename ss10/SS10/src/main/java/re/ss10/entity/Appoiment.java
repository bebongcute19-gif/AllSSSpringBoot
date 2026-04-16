package re.ss10.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Appoiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime appoimentDate;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctors doctor;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;
}
