package org.mba.clientservice.services;

import jakarta.transaction.Transactional;
import org.mba.clientservice.dto.ClientRequest;
import org.mba.clientservice.dto.ClientResponse;
import org.mba.clientservice.entities.Client;
import org.mba.clientservice.mappers.ClientMapperInterface;
import org.mba.clientservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ClientServiceImpl implements ClientServiceInterface{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapperInterface clientMapperInterface;
    @Override
    public void add(ClientRequest clientRequest) {
        Client client = clientMapperInterface.request2Client(clientRequest);
        clientRepository.save(client);
    }

    @Override
    public ClientResponse getOne(Integer id) {
        Client client = clientRepository.findById(id).get();
        ClientResponse clientResponse = clientMapperInterface.client2Response(client);
        return clientResponse;
    }

    @Override
    public List<ClientResponse> getAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponse> clientResponses=new ArrayList<>();
        for (Client client : clients)
            clientResponses.add(clientMapperInterface.client2Response(client));
        return clientResponses;
    }

    @Override
    public void update(Integer id, ClientRequest clientRequest) {
        Client client = clientRepository.findById(id).get();
        if(clientRequest.getName()!=null)
            client.setName(clientRequest.getName());
        if(clientRequest.getEmail()!=null)
            client.setEmail(clientRequest.getEmail());
        if (clientRequest.getPhone()!=null)
            client.setPhone(clientRequest.getPhone());
        clientRepository.save(client);
    }

    @Override
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
