package com.transdev.busticket.controller;

import com.transdev.busticket.domaine.Reservation;
import com.transdev.busticket.exception.RessourceNotFound;
import com.transdev.busticket.modele.MoyenPaiement;
import com.transdev.busticket.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
   ReservationService reservationService;

    @GetMapping("/listerReservation")
    ResponseEntity<List<Reservation>> getAllReservations(){
        return ResponseEntity.ok(this.reservationService.getAllReservation());
    }
    @PostMapping("/reservation")
    ResponseEntity<Reservation> creerReservation(@RequestBody Reservation reservation){
        return new ResponseEntity<>(this.reservationService.creerReservation(reservation), HttpStatus.CREATED);

    }
    @RequestMapping(value = "/Reservation/{reservationId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<Reservation> trouverReservationParId(@PathVariable long reservationId) throws RessourceNotFound {

        return ResponseEntity.ok(this.reservationService.findReservationById(reservationId));
    }
    @RequestMapping(value = "/Reservation/{reservationId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void supprimerReservation(@PathVariable long reservationId) throws RessourceNotFound {
        this.reservationService.supprimerReservation(reservationId);
    }
    @PostMapping("/payerReservation/{reservationId}")
    ResponseEntity<Boolean> payerReservation(@PathVariable long reservationId ,@RequestBody MoyenPaiement moyenPaiement){
        return ResponseEntity.ok(this.reservationService.payerReservation(reservationId,moyenPaiement));

    }
}
