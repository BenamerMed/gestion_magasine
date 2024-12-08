package org.mba.clientservice.services;

import org.mba.clientservice.dto.ClientRequest;
import org.mba.clientservice.dto.ClientResponse;

import java.util.List;


public interface ClientServiceInterface {
    //post
    public void add(ClientRequest clientRequest);
    //get one
    public ClientResponse getOne(Integer id);
    //get all
    public List<ClientResponse> getAll();
    //put
    public void update(Integer id,ClientRequest clientRequest);
    //delete
    public void delete(Integer id);

}
