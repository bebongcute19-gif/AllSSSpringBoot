package re.ss10.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.ss10.entity.Doctors;

import java.util.List;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctors, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
