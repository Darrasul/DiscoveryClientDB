package com.buzas.discoveryclientdb;

import com.buzas.discoveryclientdb.items.Product;
import com.buzas.discoveryclientdb.items.ProductService;
import com.buzas.discoveryclientdb.items.ReallyHelpfullService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class HelpfullServiceTests {
    @Autowired
    private ReallyHelpfullService testService;

    @MockBean
    private ProductService productService;

    @Test
    public void findByIdTest() {
        Product product = new Product();
        product.setId(7L);
        product.setTitle("testTitle");
        product.setPrice(200);

        Mockito.doReturn(Optional.of(product)).when(productService).findById(7L);
        Assertions.assertEquals(product, testService.getProductById(7L));
    }

    @Test
    public void findByIdFailureTest1() {
        Product product = new Product();
        product.setId(7L);
        product.setTitle("testTitle");
        product.setPrice(200);

        Mockito.doReturn(Optional.of(product)).when(productService).findById(7L);
        Assertions.assertNotEquals(new Product(11L, "test", 100), testService.getProductById(7L));
    }

    @Test
    public void findAllTest() {
        Product product1 = new Product(1L, "test#1", 100);
        Product product2 = new Product(2L, "test#2", 200);
        Product product3 = new Product(3L, "test#3", 55);
        Product product4 = new Product(4L, "test#4", 75);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        Mockito.doReturn(products).when(productService).findAll();

        Assertions.assertEquals(products.size(), testService.getAllProduct().size());
    }
}
