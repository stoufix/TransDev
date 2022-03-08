package com.transdev.busticket.repository;

import com.transdev.busticket.domaine.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrajetRepository extends JpaRepository<Trajet,Long> {
}
