package org.mba.productservice.dto;

import lombok.Data;

@Data
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private Integer price;
}
