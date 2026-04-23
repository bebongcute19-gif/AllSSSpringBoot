package re.ss13.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss13.model.entity.Employee;
import re.ss13.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
