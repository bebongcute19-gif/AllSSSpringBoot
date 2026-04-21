package re.ss12.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import re.ss12.model.dto.request.SuppliesCreateDTO;
import re.ss12.model.dto.request.SuppliesUpdateDTO;
import re.ss12.model.dto.response.SuppliesResponseDTO;
import re.ss12.model.entity.Supplies;
import re.ss12.repository.SuppliesRepository;
import re.ss12.validator.DepartmentNotFoundException;
import re.ss12.validator.DuplicateResourceException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuppliesService {
    private final SuppliesRepository suppliesRepository;
    private final ModelMapper modelMapper;

    public SuppliesResponseDTO getSuppliesById(Long id){
        Supplies s = suppliesRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Không tìm thây vật tư có id = " + id ));
        return modelMapper.map(s, SuppliesResponseDTO.class);
    }

    public SuppliesResponseDTO createSupplies(SuppliesCreateDTO req) {
        if (suppliesRepository.existsByCode(req.getCode())) {
            throw new DuplicateResourceException("Mã vật tư " + req.getCode() + " đã tồ tại");
        }
        Supplies s = modelMapper.map(req, Supplies.class);
        s.setQuantity(0);
        return modelMapper.map(suppliesRepository.save(s), SuppliesResponseDTO.class);
    }

    public SuppliesResponseDTO updateSupplies(Long id, SuppliesUpdateDTO req) {
        Supplies oldSupp = suppliesRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Không tìm thấy vật tư có id = " + id));

        if (req.getCode() != null &&
                !req.getCode().equals(oldSupp.getCode()) &&
                suppliesRepository.existsByCode(req.getCode())) {

            throw new DuplicateResourceException("Mã vật tư " + req.getCode() + " đã tồn tại");
        }

        modelMapper.getConfiguration().setSkipNullEnabled(true);

        modelMapper.map(req, oldSupp);

        Supplies updated = suppliesRepository.save(oldSupp);

        return modelMapper.map(updated, SuppliesResponseDTO.class);
    }

    public void deleteSupplies(Long id) {
        Supplies s = suppliesRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(
                        "Không tìm thấy vật tư có id = " + id));

        suppliesRepository.delete(s);
    }

    public List<SuppliesResponseDTO> findByName(String name) {
        return suppliesRepository.searchByName(name)
                .stream()
                .map(s -> modelMapper.map(s, SuppliesResponseDTO.class))
                .toList();
    }

    public List<SuppliesResponseDTO> getAllSupplies() {
        return suppliesRepository.findAll().stream()
                .map(s -> modelMapper.map(s, SuppliesResponseDTO.class))
                .toList();
    }
}
