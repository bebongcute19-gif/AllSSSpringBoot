package re.ss10.service;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import re.ss10.dto.request.AddDoctor;
import re.ss10.dto.request.DoctorUpdate;
import re.ss10.dto.response.DoctorResponse;
import re.ss10.entity.Doctors;
import re.ss10.exception.BadRequestException;
import re.ss10.exception.DataConflictException;
import re.ss10.exception.NotFoundException;
import re.ss10.repository.IDoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements IDoctorService {
    private final IDoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DoctorResponse> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(en -> modelMapper.map(en, DoctorResponse.class)).toList();
    }

    @Override
    public DoctorResponse getDoctorById(Long id) throws NotFoundException {
        return doctorRepository.findById(id)
                .stream()
                .map(en -> modelMapper.map(en, DoctorResponse.class))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Không tồn tại bác sĩ với ID là: " + id));
    }

    @Override
    public DoctorResponse createDoctor(AddDoctor request) throws DataConflictException {
        Doctors entity = modelMapper.map(request, Doctors.class);
        if (doctorRepository.existsByEmail(request.getEmail())) {
            throw new DataConflictException("Email đã tồn tại");
        }
        if (doctorRepository.existsByPhone(request.getPhone())) {
            throw new DataConflictException("Phone đã tồn tại");
        }
        doctorRepository.save(entity);
        return modelMapper.map(entity, DoctorResponse.class);
    }

    @Override
    public DoctorResponse updateDoctor(DoctorUpdate request, Long id)
            throws NotFoundException, DataConflictException , BadRequestException{

        Doctors doctors = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tồn tại bác sĩ với ID là: " + id));

        // NAME
        if (request.getName() != null) {
            if (request.getName().isBlank()) {
                throw new BadRequestException("Name không được để trống");
            }
            doctors.setName(request.getName());
        }

        // EMAIL
        if (request.getEmail() != null) {
            if (request.getEmail().isBlank()) {
                throw new BadRequestException("Email không được để trống");
            }
            if (doctorRepository.existsByEmail(request.getEmail())
                    && !doctors.getEmail().equals(request.getEmail())) {
                throw new DataConflictException("Email đã tồn tại");
            }
            doctors.setEmail(request.getEmail());
        }

        // PHONE
        if (request.getPhone() != null) {
            if (request.getPhone().isBlank()) {
                throw new BadRequestException("Phone không được để trống");
            }
            if (doctorRepository.existsByPhone(request.getPhone())
                    && !doctors.getPhone().equals(request.getPhone())) {
                throw new DataConflictException("Phone đã tồn tại");
            }
            doctors.setPhone(request.getPhone());
        }

        // ADDRESS (cho phép rỗng nếu muốn)
        if (request.getAddress() != null) {
            doctors.setAddress(request.getAddress());
        }

        Doctors updatedDoctors = doctorRepository.save(doctors);
        return modelMapper.map(updatedDoctors, DoctorResponse.class);
    }
    @Override
    public void deleteDoctorById(Long id) throws NotFoundException {
        Doctors doctors = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tồn tại bác sĩ với ID là: " + id));
        doctorRepository.delete(doctors);
    }
}
