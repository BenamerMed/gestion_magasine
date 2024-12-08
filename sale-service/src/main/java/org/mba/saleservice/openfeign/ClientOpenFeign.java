package org.mba.saleservice.openfeign;

import org.mba.saleservice.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CLIENT-SERVICE")
public interface ClientOpenFeign {
    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable("id") Integer id);
    /*
    @GetMapping("/clients")
    public List<Client> getAllClients();
     */
}
