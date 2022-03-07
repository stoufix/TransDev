package com.transdev.busticket.service.impl;

import com.transdev.busticket.domaine.Client;
import com.transdev.busticket.exception.RessourceNotFound;
import com.transdev.busticket.repository.ClientRepository;
import com.transdev.busticket.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository ;
    @Override
    public Client createClient(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client getClientById(long idClient) throws RessourceNotFound {
        Optional<Client> clientBD = this.clientRepository.findById(idClient);
        if (clientBD.isPresent()) {
            return clientBD.get();
        } else {
            throw new RessourceNotFound("pas de client dans la BD" + idClient);
        }
    }

    @Override
    public void deleteClientById(long idClient) {

    }
}
