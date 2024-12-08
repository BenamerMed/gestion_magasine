package org.mba.saleservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mba.saleservice.models.Client;
import org.mba.saleservice.models.Product;

import java.util.Date;
@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Sale {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Integer idc;
    private Integer idp;
    @Transient
    private Client client;
    @Transient
    private Product product;
}
