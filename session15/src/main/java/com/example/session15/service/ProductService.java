package com.example.session15.service;

import com.example.session15.model.dto.request.ProductCreateDTO;
import com.example.session15.model.dto.request.ProductUpdateDTO;
import com.example.session15.model.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> findAll();

    ProductResponseDTO create(ProductCreateDTO req);

    ProductResponseDTO update(Long id, ProductUpdateDTO req);

    void delete(Long id);
}
