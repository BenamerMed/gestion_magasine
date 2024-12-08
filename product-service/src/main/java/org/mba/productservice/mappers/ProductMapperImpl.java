package org.mba.productservice.mappers;

import org.mba.productservice.dto.ProductRequest;
import org.mba.productservice.dto.ProductResponse;
import org.mba.productservice.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapperInterface{
    @Override
    public Product Request2Product(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        return product;
    }

    @Override
    public ProductResponse Product2Response(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setDescription(product.getDescription());
        return productResponse;
    }
}
