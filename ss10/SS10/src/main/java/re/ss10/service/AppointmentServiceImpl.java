package re.ss10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss10.dto.response.AppoimentResponse;
import re.ss10.entity.Appoiment;
import re.ss10.entity.Doctors;
import re.ss10.exception.NotFoundException;
import re.ss10.mapper.AppointmentMapper;
import re.ss10.repository.IAppointmentRepository;
import re.ss10.repository.IDoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements IAppointmentService {
    private final IAppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final IDoctorRepository doctorRepository;
    @Override
    public List<AppoimentResponse>  getByDoctorId(Long id) throws NotFoundException {
        Doctors doctors = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bác sĩ không tồn tại!!"));
        List<Appoiment> appoiments= appointmentRepository.findByDoctorId(id);
        return appointmentMapper.toResponseList(appoiments);
    }
}
