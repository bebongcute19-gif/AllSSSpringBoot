package re.ss10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.ss10.entity.Prescription;

import java.util.List;

@Repository
public interface IPrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByPatientId(Long patientId);
}
