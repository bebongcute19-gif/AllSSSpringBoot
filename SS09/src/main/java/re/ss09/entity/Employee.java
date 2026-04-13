package re.ss09.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private Long salary;

    @ManyToOne
    @JoinColumn(name= "department_id", nullable = false)
    private Department department;
}
