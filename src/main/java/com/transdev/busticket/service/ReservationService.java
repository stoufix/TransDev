package com.transdev.busticket.service;

import com.transdev.busticket.domaine.Billet;
import com.transdev.busticket.domaine.Reservation;
import com.transdev.busticket.exception.RessourceNotFound;
import com.transdev.busticket.modele.MoyenPaiement;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservation();
    Reservation findReservationById(long idReservation) throws RessourceNotFound;
    Reservation creerReservation(Reservation reservation);
    void supprimerReservation(long idReservation) throws RessourceNotFound;
    Billet recupererBilletFacture(long idReservation) throws RessourceNotFound;
    boolean payerReservation(long idReservation , MoyenPaiement moyenPaiment);
}
