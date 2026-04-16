package re.ss10.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
     @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appoiment> appoiments;
     @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;
}
