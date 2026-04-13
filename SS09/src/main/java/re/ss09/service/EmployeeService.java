package re.ss09.service;

import re.ss09.dto.EmployeeCreateDTO;
import re.ss09.entity.Employee;

public interface EmployeeService {
    Employee create(EmployeeCreateDTO dto);
}
