package re.ss09.mapper;

import re.ss09.dto.DepartmentDTO;
import re.ss09.entity.Department;

public class DepartmentMapper {

    public static Department toEntity(DepartmentDTO dto) {
        return Department.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}