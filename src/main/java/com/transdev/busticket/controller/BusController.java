package com.transdev.busticket.controller;

import com.transdev.busticket.domaine.Bus;
import com.transdev.busticket.exception.RessourceNotFound;
import com.transdev.busticket.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class BusController {

    @Autowired
    BusService busService;

    @GetMapping("/listerBus")
    ResponseEntity<List<Bus>> getAllBus(){
        return ResponseEntity.ok(this.busService.getAllBus());
    }
    @PostMapping("/bus")
    ResponseEntity<Bus> creerBus(@RequestBody Bus bus){
      //  return ResponseEntity.ok(this.busService.creerBus(bus));
        return new ResponseEntity<>(this.busService.creerBus(bus), HttpStatus.CREATED);

    }
    @RequestMapping(value = "/bus/{busId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<Bus> trouverBusParId(@PathVariable long busId) throws RessourceNotFound {

        return ResponseEntity.ok(this.busService.findBusById(busId));
    }
    @RequestMapping(value = "/bus/{busId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void supprimerBus(@PathVariable long busId) throws RessourceNotFound {
        this.busService.supprimerBus(busId);
    }
}
