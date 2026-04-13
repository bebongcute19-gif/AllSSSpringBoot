package re.ss09.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss09.dto.EmployeeCreateDTO;
import re.ss09.entity.Department;
import re.ss09.entity.Employee;
import re.ss09.exception.DuplicateResourceException;
import re.ss09.exception.ResourceNotFoundException;
import re.ss09.repository.DepartmentRepository;
import re.ss09.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    @Override
    public Employee create (EmployeeCreateDTO dto){
        //check department tồn tại
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Phòng ban với id " + dto.getDepartmentId()+" không tồn tại."));
        //check email trung
        if(employeeRepository.existsByEmail(dto.getEmail())){
            throw  new DuplicateResourceException("Email " + dto.getEmail() + " đã tồn tại.");
        }

        Employee employee = Employee.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .department(department)
                .build();
        return employeeRepository.save(employee);
    }
}
