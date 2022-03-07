package com.transdev.busticket.controller;

import com.transdev.busticket.domaine.Client;
import com.transdev.busticket.service.ClientService;
import com.transdev.busticket.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    ResponseEntity<List<Client>> getAllClients(){

        return ResponseEntity.ok(this.clientService.getAllClients());

    }
    @PostMapping("/client")

    ResponseEntity<Client> createClient(@RequestBody Client client){
        return ResponseEntity.ok(this.clientService.createClient(client));
    }
}
