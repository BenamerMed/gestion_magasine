package org.mba.saleservice.services;

import org.mba.saleservice.dto.SaleRequest;
import org.mba.saleservice.dto.SaleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SaleServiceInterface {
    //Post getall getOne delete update
    public void add(SaleRequest saleRequest);
    public SaleResponse getOne(Integer id);
    public List<SaleResponse> getAll();
    public void update(SaleRequest saleRequest, Integer id);
    public void delete(Integer id);
}
