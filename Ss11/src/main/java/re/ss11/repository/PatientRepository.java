package re.ss11.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.ss11.model.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}