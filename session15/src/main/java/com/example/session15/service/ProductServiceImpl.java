package com.example.session15.service;

import com.example.session15.model.dto.request.ProductCreateDTO;
import com.example.session15.model.dto.request.ProductUpdateDTO;
import com.example.session15.model.entity.Product;
import com.example.session15.model.dto.response.ProductResponseDTO;
import com.example.session15.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public ProductResponseDTO create(ProductCreateDTO req) {
        Product product = new Product();
        mapData(req, product);

        return toResponse(productRepository.save(product));
    }

    @Override
    public ProductResponseDTO update(Long id, ProductUpdateDTO req) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));

        mapData(req, product);

        return toResponse(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));

        productRepository.delete(product);
    }

    private ProductResponseDTO toResponse(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .size(product.getSize())
                .toppings(product.getToppings())
                .build();
    }

    private void mapData(ProductCreateDTO req, Product product) {
        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());
        product.setSize(req.getSize());
        product.setToppings(req.getToppings());
    }

    private void mapData(ProductUpdateDTO req, Product product) {
        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());
        product.setSize(req.getSize());
        product.setToppings(req.getToppings());
    }
}
