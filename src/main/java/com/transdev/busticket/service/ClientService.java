package com.transdev.busticket.service;

import com.transdev.busticket.domaine.Client;
import com.transdev.busticket.exception.RessourceNotFound;

import java.util.List;

public interface ClientService {

    Client createClient(Client client) ;
    List<Client> getAllClients();
    Client getClientById(long idClient) throws RessourceNotFound;
    void deleteClientById(long idClient);
}
