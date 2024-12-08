package org.mba.saleservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    private Integer id;
    private String name;
    private String email;
    private String phone;
}
