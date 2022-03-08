package com.transdev.busticket.service.impl;

import com.transdev.busticket.domaine.Reservation;
import com.transdev.busticket.domaine.Trajet;
import com.transdev.busticket.exception.RessourceNotFound;
import com.transdev.busticket.modele.MoyenPaiement;
import com.transdev.busticket.repository.ReservationRepository;
import com.transdev.busticket.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository ;
    @Override
    public List<Reservation> getAllReservation() {
        return this.reservationRepository.findAll();
    }

    @Override
    public Reservation findReservationById(long idReservation) throws RessourceNotFound {
        Optional<Reservation> reservationBD = this.reservationRepository.findById(idReservation);
        if(reservationBD.isPresent()){
            return reservationBD.get();
        }
        else {
            throw new RessourceNotFound("pas de bus dans la BD" + idReservation);
        }
    }

    @Override
    public Reservation creerReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @Override
    public void supprimerReservation(long idReservation) throws RessourceNotFound {
        Optional<Reservation> reservationBD = this.reservationRepository.findById(idReservation);
        if(reservationBD.isPresent()){
             this.reservationRepository.deleteAllById(Collections.singleton(idReservation));
        }
        else {
            throw new RessourceNotFound("pas de bus dans la BD" + idReservation);
        }
    }
    @Override
    public boolean payerReservation(long idReservation, MoyenPaiement moyenPaiment) {
        Optional<Reservation> reservationBD = this.reservationRepository.findById(idReservation);

        if(reservationBD.isPresent()){
            reservationBD.get().getTrajet().stream()
                    .filter(item -> item.getPrix() >= 100)
                    .forEach(trajet -> trajet.setPrix(trajet.getPrix()*95/100));
        }
        return moyenPaiment.payerReservation(idReservation);
    }
}
