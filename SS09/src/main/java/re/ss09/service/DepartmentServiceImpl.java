package re.ss09.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss09.dto.DepartmentDTO;
import re.ss09.entity.Department;
import re.ss09.mapper.DepartmentMapper;
import re.ss09.repository.DepartmentRepository;
import re.ss09.service.DepartmentService;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public Department create(DepartmentDTO dto) {
        Department department = DepartmentMapper.toEntity(dto);
        return repository.save(department);
    }
}