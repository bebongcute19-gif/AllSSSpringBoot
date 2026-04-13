package re.ss09.service;


import re.ss09.dto.DepartmentDTO;
import re.ss09.entity.Department;

public interface DepartmentService {
    Department create(DepartmentDTO departmentDTO);
}
