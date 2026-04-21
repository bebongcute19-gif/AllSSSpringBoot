package re.ss11.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import re.ss11.model.dto.response.PrescriptionResponseDTO;
import re.ss11.model.entity.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    @Query("""
    SELECT new re.ss11.model.dto.response.PrescriptionResponseDTO(
        p.id,
        p.prescriptionDate,
        p.description,
        pt.id,
        pt.name
    )
    FROM Prescription p
    JOIN p.patient pt
    WHERE p.id = :prescriptionId AND pt.id = :patientId
""")
    PrescriptionResponseDTO findByIdAndPatientId(Long prescriptionId, Long patientId);
}
