package com.buzas.discoveryclientdb.items;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReallyHelpfullService {
    private final ProductService productService;

    public Product getProductById (Long id) {
        return productService.findById(id).orElseThrow(() -> new FindException("No such product with id:" + id));
    }

    public List<Product> getAllProduct () {
        return productService.findAll();
    }
}
