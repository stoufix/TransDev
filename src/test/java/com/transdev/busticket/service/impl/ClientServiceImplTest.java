package com.transdev.busticket.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import com.transdev.busticket.domaine.Client;
import com.transdev.busticket.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClientServiceImplTest {

    @Autowired
    private TestEntityManager entityManager;

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
        assertEquals(clientBD.getNom(),"test");

    }

    @Test
    void getAllClients() {
       // arrenge
        Client client1 = new Client();
        client1.setEmail("mm@mm");
        client1.setNom("test1");
        entityManager.persist(client1);

        Client client2 = new Client();
        client2.setEmail("a@a");
        client2.setNom("test2");
        entityManager.persist(client2);
        //act

        Iterable<Client> clients = this.clientRepository.findAll();
        //assert
        assertThat(clients).hasSize(2).contains(client1, client2);
    }

    @Test
    void getClientById() {

        Client client1 = new Client();
        client1.setEmail("mm@mm");
        client1.setNom("test1");
        entityManager.persist(client1);


        Client clientExpected = this.clientRepository.findById(client1.getIdClient()).get();

        assertNotNull(clientExpected);
        assertEquals(clientExpected.getEmail(),"mm@mm");
        assertEquals(clientExpected.getNom(),"test1");
    }
    @Test
    void deleteClientById() {
        Client client1 = new Client();
        client1.setEmail("mm@mm");
        client1.setNom("test1");
        entityManager.persist(client1);
        this.clientRepository.deleteById(client1.getIdClient());

        assertThat(this.clientRepository.findById(client1.getIdClient())).isEmpty();
    }
}