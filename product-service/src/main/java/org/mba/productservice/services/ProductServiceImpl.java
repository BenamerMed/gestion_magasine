package org.mba.productservice.services;

import jakarta.transaction.Transactional;
import org.mba.productservice.dto.ProductRequest;
import org.mba.productservice.dto.ProductResponse;
import org.mba.productservice.entities.Product;
import org.mba.productservice.mappers.ProductMapperInterface;
import org.mba.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class ProductServiceImpl implements ProductServiceInterface{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapperInterface productMapperInterface;
    @Override
    public void add(ProductRequest productRequest) {
        productRepository.save(productMapperInterface.Request2Product(productRequest));
    }

    @Override
    public ProductResponse getOne(Integer id) {
        return productMapperInterface.Product2Response(productRepository.findById(id).get());
    }

    @Override
    public List<ProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product : products){
            productResponses.add(productMapperInterface.Product2Response(product));
        }
        return productResponses;
    }

    @Override
    public void update(Integer id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).get();
        if(productRequest.getName()!=null)
            product.setName(productRequest.getName());
        if(productRequest.getDescription()!=null)
            product.setDescription(productRequest.getDescription());
        if(productRequest.getPrice()!=null)
            product.setPrice(productRequest.getPrice());
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
