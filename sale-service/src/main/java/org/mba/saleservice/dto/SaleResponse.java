package org.mba.saleservice.dto;

import lombok.Data;
import org.mba.saleservice.models.Client;
import org.mba.saleservice.models.Product;

import java.util.Date;
@Data
public class SaleResponse {
    private Integer id;
    private Date date;
    private Integer idc;
    private Integer idp;
    private Client client;
    private Product product;
}
