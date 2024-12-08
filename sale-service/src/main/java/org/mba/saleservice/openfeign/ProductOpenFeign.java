package org.mba.saleservice.openfeign;

import org.mba.saleservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductOpenFeign {
    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable int id);
    /*
    @GetMapping("products")
    public List<Product> getProducts();

     */
}
