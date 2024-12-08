package org.mba.saleservice.dto;

import lombok.Data;

import java.util.Date;
@Data
public class SaleRequest {
    private Date date;
    private Integer idc;
    private Integer idp;
}
