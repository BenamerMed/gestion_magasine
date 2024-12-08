package org.mba.saleservice.services;

import jakarta.transaction.Transactional;
import org.mba.saleservice.dto.SaleRequest;
import org.mba.saleservice.dto.SaleResponse;
import org.mba.saleservice.entities.Sale;
import org.mba.saleservice.mappers.SaleMapperInterface;
import org.mba.saleservice.models.Client;
import org.mba.saleservice.models.Product;
import org.mba.saleservice.openfeign.ClientOpenFeign;
import org.mba.saleservice.openfeign.ProductOpenFeign;
import org.mba.saleservice.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class SaleServiceImpl implements SaleServiceInterface{
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleMapperInterface saleMapperInterface;
    @Autowired
    private ClientOpenFeign clientOpenFeign;
    @Autowired
    private ProductOpenFeign productOpenFeign;
    @Override
    public void add(SaleRequest saleRequest) {
        saleRepository.save(saleMapperInterface.request2Sale(saleRequest));
    }

    @Override
    public SaleResponse getOne(Integer id) {
        Sale sale = saleRepository.findById(id).get();
        Client client = clientOpenFeign.getClientById(sale.getIdc());
        client.setId(sale.getIdc());
        Product product = productOpenFeign.getProduct(sale.getIdp());
        product.setId(sale.getIdp());
        sale.setClient(client);
        sale.setProduct(product);
        return saleMapperInterface.sale2Response(sale);
    }

    @Override
    public List<SaleResponse> getAll() {
        List<SaleResponse> saleResponses = new ArrayList<>();
        List<Sale> sales = saleRepository.findAll();
        Client client;
        Product product;
        for (Sale sale : sales) {
            client = clientOpenFeign.getClientById(sale.getIdc());
            client.setId(sale.getIdc());
            product = productOpenFeign.getProduct(sale.getIdp());
            product.setId(sale.getIdp());
            sale.setClient(client);
            sale.setProduct(product);
            saleResponses.add(saleMapperInterface.sale2Response(sale));
        }
        return saleResponses;
    }

    @Override
    public void update(SaleRequest saleRequest, Integer id) {
        Sale sale = saleRepository.findById(id).get();
        if(saleRequest.getIdp()!=null)
            sale.setIdp(saleRequest.getIdp());
        if(saleRequest.getIdc()!=null)
            sale.setIdc(saleRequest.getIdc());
        if(saleRequest.getDate()!=null)
            sale.setDate(saleRequest.getDate());
        saleRepository.save(sale);
    }

    @Override
    public void delete(Integer id) {
        saleRepository.deleteById(id);
    }
}
