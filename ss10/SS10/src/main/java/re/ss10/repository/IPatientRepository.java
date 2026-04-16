package re.ss10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.ss10.entity.Patients;

@Repository
public interface IPatientRepository extends JpaRepository<Patients, Long> {
}
