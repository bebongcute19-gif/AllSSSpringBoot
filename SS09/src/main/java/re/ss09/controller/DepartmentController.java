package re.ss09.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import re.ss09.dto.ApiResponse;
import re.ss09.dto.DepartmentDTO;
import re.ss09.entity.Department;
import re.ss09.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Department> create(@Valid @RequestBody DepartmentDTO departmentDTO) {
        Department department = departmentService.create(departmentDTO);
        return ApiResponse.<Department>builder()
                .status("SUCCESS")
                .message("Tạo phòng ban thành công")
                .data(department).build();

    }
}
