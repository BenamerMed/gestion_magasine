package org.mba.clientservice.web;

import org.mba.clientservice.dto.ClientRequest;
import org.mba.clientservice.dto.ClientResponse;
import org.mba.clientservice.services.ClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientRestController {
    @Autowired
    private ClientServiceInterface clientService;
    /*
    @Operation(summary = "Get all clients", description = "Fetch a list of all clients.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Clients retrieved successfully."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    */
    @GetMapping("/clients")
    public List<ClientResponse> allClient() {
        return clientService.getAll();
    }

    @GetMapping("/clients/{id}")
    public ClientResponse oneClient(@PathVariable Integer id) {
        return clientService.getOne(id);
    }
    @PostMapping("/clients")
    public void addClient(@RequestBody ClientRequest clientRequest) {
        clientService.add(clientRequest);
    }
    @PutMapping("/clients/{id}")
    public void updateClient(@PathVariable Integer id, @RequestBody ClientRequest clientRequest) {
        clientService.update(id, clientRequest);
    }
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
    }

}
