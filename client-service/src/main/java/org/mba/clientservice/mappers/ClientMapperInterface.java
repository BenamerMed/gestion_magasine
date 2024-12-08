package org.mba.clientservice.mappers;

import org.mba.clientservice.dto.ClientRequest;
import org.mba.clientservice.dto.ClientResponse;
import org.mba.clientservice.entities.Client;
import org.springframework.stereotype.Component;

@Component
public interface ClientMapperInterface {
    public Client request2Client(ClientRequest clientRequest);
    public ClientResponse client2Response(Client client);
}
