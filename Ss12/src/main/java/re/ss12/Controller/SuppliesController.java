package re.ss12.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import re.ss12.mapping.MapToAPIResponse;
import re.ss12.model.dto.request.SuppliesCreateDTO;
import re.ss12.model.dto.request.SuppliesUpdateDTO;
import re.ss12.model.dto.response.SuppliesResponseDTO;
import re.ss12.service.SuppliesService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/supplies")
@RequiredArgsConstructor
public class SuppliesController {
    private final SuppliesService suppliesService;

    @PostMapping
    public ResponseEntity<?> createSupplies(@Valid @RequestBody SuppliesCreateDTO req) {
        SuppliesResponseDTO res = suppliesService.createSupplies(req);
        return new ResponseEntity<>(MapToAPIResponse.mapTo(res, 201, "Tạo mới vật tư thành công"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupplies(@PathVariable Long id, @Valid @RequestBody SuppliesUpdateDTO udReq) {
        SuppliesResponseDTO res = suppliesService.updateSupplies(id, udReq);
        return new ResponseEntity<>(MapToAPIResponse.mapTo(res, 200, "Chỉnh sửa vật tư thành công"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplies(@PathVariable Long id) {
        suppliesService.deleteSupplies(id);
        return new ResponseEntity<>(MapToAPIResponse.mapTo(null, 204, "Xoá vật tư thành công"), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    private ResponseEntity<?> findByName(@RequestParam String name) {
        List<SuppliesResponseDTO> listSupplies = suppliesService.findByName(name);
        return new ResponseEntity<>(MapToAPIResponse.mapTo(listSupplies, 200, "Dữ liệu được lấy thành công"), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<?> getAll() {
        List<SuppliesResponseDTO> listSupplies = suppliesService.getAllSupplies();
        return new ResponseEntity<>(MapToAPIResponse.mapTo(listSupplies, 200, "Dữ liệu được lấy thành công"), HttpStatus.OK);
    }
}
