package com.transdev.busticket.controller;

import com.transdev.busticket.domaine.Bus;
import com.transdev.busticket.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BusController {

    @Autowired
    BusService busService;

    @GetMapping("/bus")
    ResponseEntity<List<Bus>> getAllBus(){

        return ResponseEntity.ok(this.busService.getAllBus());

    }
}
