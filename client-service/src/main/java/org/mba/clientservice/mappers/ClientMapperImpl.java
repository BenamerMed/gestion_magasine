package org.mba.clientservice.mappers;

import org.mba.clientservice.dto.ClientRequest;
import org.mba.clientservice.dto.ClientResponse;
import org.mba.clientservice.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl implements ClientMapperInterface{
    @Override
    public Client request2Client(ClientRequest clientRequest) {
        Client client = new Client();
        client.setName(clientRequest.getName());
        client.setEmail(clientRequest.getEmail());
        client.setPhone(clientRequest.getPhone());
        return client;
    }

    @Override
    public ClientResponse client2Response(Client client) {
        ClientResponse response = new ClientResponse();
        response.setId(client.getId());
        response.setName(client.getName());
        response.setEmail(client.getEmail());
        response.setPhone(client.getPhone());
        return response;
    }
}
