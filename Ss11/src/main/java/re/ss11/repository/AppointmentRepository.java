package re.ss11.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import re.ss11.model.dto.response.AppointmentResponseDTO;
import re.ss11.model.entity.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("""
        SELECT new re.ss11.model.dto.response.AppointmentResponseDTO(
            a.id,
            a.appointmentTime,
            a.note,
            a.status,
            d.id,
            d.name
        )
        FROM Appointment a
        JOIN a.doctor d
        WHERE d.id = :doctorId
    """)
    List<AppointmentResponseDTO> findAllByDoctorId(Long doctorId);
}