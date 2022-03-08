package com.transdev.busticket.service;

import com.transdev.busticket.domaine.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservation();
    Reservation findReservationById(long idReservation);
    Reservation creerReservation(Reservation reservation);
    void supprimerReservation(long idReservation);
    boolean payerReservation(long idReservation , String moyenPaiment);
}
