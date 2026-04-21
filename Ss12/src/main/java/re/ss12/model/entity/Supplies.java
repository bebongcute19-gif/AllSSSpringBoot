package re.ss12.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "supplies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên vật tư
    @Column(nullable = false)
    private String name;

    // Mã vật tư
    @Column(nullable = false, unique = true)
    private String code;

    // Số lượng
    private Integer quantity = 0;

    // Giá
    private Double price;

    // Mô tả
    private String description;
}