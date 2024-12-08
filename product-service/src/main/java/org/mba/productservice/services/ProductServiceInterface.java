package org.mba.productservice.services;

import org.mba.productservice.dto.ProductRequest;
import org.mba.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductServiceInterface {
    //post
    public void add(ProductRequest productRequest);
    //get one
    public ProductResponse getOne(Integer id);
    //get all
    public List<ProductResponse> getAll();
    //put
    public void update(Integer id, ProductRequest productRequest);
    //delete
    public void delete(Integer id);
}
