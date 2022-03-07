package com.transdev.busticket.service.impl;

import com.transdev.busticket.domaine.Client;
import com.transdev.busticket.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class ClientServiceImplTest {


     @Autowired
    ClientRepository clientRepository ;

    @Test
    void createClient() {

        //arr
        Client client = new Client();
        client.setEmail("mm@mm");
        client.setNom("test");
        Client clientBD = this.clientRepository.save(client);
        assertNotNull(clientBD);
        assertEquals(clientBD.getEmail(),"mm@mm");

    }

    @Test
    void getAllClients() {
    }

    @Test
    void getClientById() {
    }

    @Test
    void deleteClientById() {
    }
}