package org.mba.saleservice.mappers;

import org.mba.saleservice.dto.SaleRequest;
import org.mba.saleservice.dto.SaleResponse;
import org.mba.saleservice.entities.Sale;
import org.springframework.stereotype.Component;

@Component
public class SaleMapperImpl implements SaleMapperInterface{

    @Override
    public Sale request2Sale(SaleRequest saleRequest) {
        Sale sale = new Sale();
        sale.setDate(saleRequest.getDate());
        sale.setIdc(saleRequest.getIdc());
        sale.setIdp(saleRequest.getIdp());
        //sale.setClient();
        //sale.setProduct();
        return sale;
    }
    @Override
    public SaleResponse sale2Response(Sale sale) {
        SaleResponse saleResponse = new SaleResponse();
        saleResponse.setId(sale.getId());
        saleResponse.setDate(sale.getDate());
        saleResponse.setIdc(sale.getIdc());
        saleResponse.setIdp(sale.getIdp());
        saleResponse.setClient(sale.getClient());
        saleResponse.setProduct(sale.getProduct());
        return saleResponse;
    }
}
