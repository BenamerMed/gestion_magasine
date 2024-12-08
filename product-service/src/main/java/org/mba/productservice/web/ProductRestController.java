package org.mba.productservice.web;

import org.mba.productservice.dto.ProductRequest;
import org.mba.productservice.dto.ProductResponse;
import org.mba.productservice.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    @Autowired
    private ProductServiceInterface productService;
    @GetMapping("/products")
    public List<ProductResponse> allProducts() {
        return productService.getAll();
    }
    @GetMapping("/products/{id}")
    public ProductResponse findProductById(@PathVariable Integer id) {
        return productService.getOne(id);
    }
    @PostMapping("/products")
    public void addProduct(@RequestBody ProductRequest productRequest) {
        productService.add(productRequest);
    }
    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest) {
        productService.update(id, productRequest);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
    }
}
