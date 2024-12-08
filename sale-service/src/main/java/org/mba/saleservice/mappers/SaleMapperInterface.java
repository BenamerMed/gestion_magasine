package org.mba.saleservice.mappers;

import org.mba.saleservice.dto.SaleRequest;
import org.mba.saleservice.dto.SaleResponse;
import org.mba.saleservice.entities.Sale;
import org.springframework.stereotype.Component;

@Component
public interface SaleMapperInterface {
    public Sale request2Sale(SaleRequest saleRequest);
    public SaleResponse sale2Response(Sale sale);
}
