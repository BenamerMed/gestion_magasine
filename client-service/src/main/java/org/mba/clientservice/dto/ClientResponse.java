package org.mba.clientservice.dto;

import lombok.Data;

//@Schema(description = "Response DTO for client details")
@Data
//@Component
public class ClientResponse {
    //@Schema(description = "Unique ID of the client")
    private Integer id;
    //@Schema(description = "Name of the client")
    private String name;
    //@Schema(description = "Email address of the client")
    private String email;
    //@Schema(description = "Phone number of the client")
    private String phone;
}