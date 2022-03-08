package com.transdev.busticket.controller;

import com.transdev.busticket.domaine.Bus;
import com.transdev.busticket.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class BusController {

    @Autowired
    BusService busService;

    @GetMapping("/bus")
    ResponseEntity<List<Bus>> getAllBus(){

        return ResponseEntity.ok(this.busService.getAllBus());

    }
}
