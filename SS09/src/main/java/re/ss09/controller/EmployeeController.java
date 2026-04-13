package re.ss09.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import re.ss09.dto.ApiResponse;
import re.ss09.dto.EmployeeCreateDTO;
import re.ss09.entity.Employee;
import re.ss09.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Employee> create(@Valid @RequestBody EmployeeCreateDTO dto) {
        Employee employee = service.create(dto);
        return  ApiResponse.<Employee>builder()
                .status("Success")
                .message("Tạo nhân viên thành công")
                .data(employee).build();
    }
}
