package org.mba.productservice.mappers;

import org.mba.productservice.dto.ProductRequest;
import org.mba.productservice.dto.ProductResponse;
import org.mba.productservice.entities.Product;

public interface ProductMapperInterface {
    public Product Request2Product(ProductRequest productRequest);
    public ProductResponse Product2Response(Product product);
}
