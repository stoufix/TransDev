package com.transdev.busticket.repository;

import com.transdev.busticket.domaine.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
