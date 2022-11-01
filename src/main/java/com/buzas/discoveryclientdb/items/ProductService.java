package com.buzas.discoveryclientdb.items;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    public void addProduct(String title, Integer price) {
        productRepo.insertNewProduct(title, price);
    }
}
