package re.ss10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.ss10.entity.Appoiment;

import java.util.List;
@Repository
public interface IAppointmentRepository extends JpaRepository<Appoiment, Long> {
    List<Appoiment> findByDoctorId(Long doctorId);
}
